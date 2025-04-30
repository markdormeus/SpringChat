package com.mdormeus.springchat.service;

import com.mdormeus.springchat.entity.ChatMessage;
import com.mdormeus.springchat.repo.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        // Generate a unique ID for the message
        chatMessage.setId(UUID.randomUUID().toString());

        if (chatMessage.getTimestamp() == null) {
            chatMessage.setTimestamp(LocalDateTime.now());
        }

        var chatId = chatRoomService.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow();
        chatMessage.setChatId(chatId);

        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(
            String senderId, String recipientId
    ) {
        var chatId = chatRoomService.getChatRoomId(
                senderId,
                recipientId,
                false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }

    public ChatMessage findById(String id) {
        return chatMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
    }
}
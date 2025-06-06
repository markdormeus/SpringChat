package com.mdormeus.springchat.repo;

import com.mdormeus.springchat.entity.ChatRoom;
import com.mdormeus.springchat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}

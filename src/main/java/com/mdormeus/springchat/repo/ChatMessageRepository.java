package com.mdormeus.springchat.repo;

import com.mdormeus.springchat.entity.ChatMessage;
import com.mdormeus.springchat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {
}

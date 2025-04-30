package com.mdormeus.springchat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="chatmessage")
public class ChatMessage {
    @Id
    private String id;

    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "recipient_id")
    private String recipientId;

    private String content;

    private LocalDateTime timestamp;



}

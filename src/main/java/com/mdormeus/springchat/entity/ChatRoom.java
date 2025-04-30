package com.mdormeus.springchat.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="chatroom")
public class ChatRoom {
    @Id
    private String id;

    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "recipient_id")
    private String recipientId;

}

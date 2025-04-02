package com.mdormeus.springchat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="chatroom")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String chatId;

    private String senderId;

    private String recipientId;

}

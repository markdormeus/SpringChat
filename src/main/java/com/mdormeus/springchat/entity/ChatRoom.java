package com.mdormeus.springchat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column
    private int id;

    @Column
    private String chatId;

    @Column
    private String senderId;

    @Column
    private String recipientId;

}

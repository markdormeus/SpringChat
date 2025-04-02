package com.mdormeus.springchat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="chatmessage")
public class ChatMessage {
    @Id
    @Column

    private String id;

    private String chatId;

    @Column
    private String senderId;

    @Column
    private String recipientId;

    @Column
    private String content;

    @Column
    private Time timestamp;



}

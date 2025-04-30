package com.mdormeus.springchat.entity;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {
    private String id;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "recipient_id")
    private String recipientId;

    private String content;
}

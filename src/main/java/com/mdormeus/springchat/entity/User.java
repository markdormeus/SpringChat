package com.mdormeus.springchat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="chatuser")
public class User {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "fullname")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Status status;

}

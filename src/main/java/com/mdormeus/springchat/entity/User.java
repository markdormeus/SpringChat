package com.mdormeus.springchat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
public class User {
    @Id
    @Column
    private String username;

    @Column
    private String fullName;

    @Column
    private String password;

    @Column
    private Status status;

}

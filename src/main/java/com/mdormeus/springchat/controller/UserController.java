package com.mdormeus.springchat.controller;

import com.mdormeus.springchat.entity.User;
import com.mdormeus.springchat.repo.UserRepository;
import com.mdormeus.springchat.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(service.findConnectedUsers());
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic") //new queue for notifs
    public User addUser(@Payload User user) {
        service.saveUser(user);
        return user; //subscribe to topic/queue
    }

    @MessageMapping("/user.disconnectedUser")
    @SendTo("/user/topic") //new queue for notifs
    public User disconnect(@Payload User user) {
        service.disconnect(user);
        return user; //subscribe to topic/queue
    }




}
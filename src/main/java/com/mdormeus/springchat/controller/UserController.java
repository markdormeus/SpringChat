package com.mdormeus.springchat.controller;

import com.mdormeus.springchat.entity.User;
import com.mdormeus.springchat.repo.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findUsers() {
        return userRepository.findAll();
    }


    @SneakyThrows
    @GetMapping("/{id}")
    public User findUser(@PathVariable int id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not available"));
        return user;
    }



}
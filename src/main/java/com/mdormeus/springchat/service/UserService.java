package com.mdormeus.springchat.service;

import com.mdormeus.springchat.entity.User;
import com.mdormeus.springchat.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}

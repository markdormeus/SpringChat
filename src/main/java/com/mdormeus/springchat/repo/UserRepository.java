package com.mdormeus.springchat.repo;

import com.mdormeus.springchat.entity.Status;
import com.mdormeus.springchat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByStatus(Status status);
}

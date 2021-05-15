package com.example.spring_boot.dao;

import com.example.spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findOneByUsername(String username);
}

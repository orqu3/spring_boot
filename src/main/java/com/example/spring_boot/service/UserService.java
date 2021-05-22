package com.example.spring_boot.service;

import com.example.spring_boot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Page<User> findAll(PageRequest pageRequest);

    Optional<User> findByUsername(String username);
}

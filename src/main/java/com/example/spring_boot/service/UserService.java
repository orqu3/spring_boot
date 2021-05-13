package com.example.spring_boot.service;

import com.example.spring_boot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserService {
    Page<User> findAll(PageRequest pageRequest);
}

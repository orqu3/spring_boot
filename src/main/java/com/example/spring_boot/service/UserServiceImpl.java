package com.example.spring_boot.service;

import com.example.spring_boot.dao.UserDAO;
import com.example.spring_boot.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(PageRequest pageRequest) {
        return userDAO.findAll(pageRequest);
    }
}

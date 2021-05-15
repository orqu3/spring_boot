package com.example.spring_boot.service;

import com.example.spring_boot.dao.AuthorityDAO;
import com.example.spring_boot.dao.UserDAO;
import com.example.spring_boot.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final AuthorityDAO authorityDAO;

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(PageRequest pageRequest) {
        return userDAO.findAll(pageRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOneByUsername(String username) {
        return userDAO.findOneByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}


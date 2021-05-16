package com.example.spring_boot.service;

import com.example.spring_boot.dao.AuthorityDAO;
import com.example.spring_boot.dao.UserDAO;
import com.example.spring_boot.entity.Authority;
import com.example.spring_boot.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

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
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
    }
}


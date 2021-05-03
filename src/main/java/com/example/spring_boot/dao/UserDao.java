package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.entity.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    User saveOrUpdate(User user);
    List<Product> findUserProducts(Long id);
}

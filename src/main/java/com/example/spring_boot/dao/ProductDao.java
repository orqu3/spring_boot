package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.entity.User;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
    List<User> findProductUsers(Long id);
}

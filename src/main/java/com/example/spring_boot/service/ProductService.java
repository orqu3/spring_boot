package com.example.spring_boot.service;

import com.example.spring_boot.model.entity.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);
}

package com.example.spring_boot.model.repository;

import com.example.spring_boot.model.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);

}

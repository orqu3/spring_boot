package com.example.spring_boot.service;

import com.example.spring_boot.model.entity.Product;

import java.util.List;

public interface ProductService {

    void add_product(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);
}

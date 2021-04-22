package com.example.spring_boot.model.repository;

import com.example.spring_boot.model.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product getProductById(int id);

    void add_product(Product product);

    List<Product> getAllProducts();

}

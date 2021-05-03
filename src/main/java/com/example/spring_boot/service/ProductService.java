package com.example.spring_boot.service;

import com.example.spring_boot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);
    List<Product> findAll();
    Object deleteById(Long id);
    Product save(Product product);
    List<Product> findProductsByPriceIsGreaterThan(int minPrice);
    List<Product> findProductsByPriceIsLessThan(int maxPrice);
    List<Product> findProductsByPriceIsBetween(int minPrice, int maxPrice);
}

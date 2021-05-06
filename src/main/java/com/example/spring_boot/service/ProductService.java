package com.example.spring_boot.service;

import com.example.spring_boot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Page<Product> findAll(PageRequest pageRequest);

    void deleteById(Long id);

    Product save(Product product);

    List<Product> findProductsByPriceIsGreaterThan(int minPrice);

    List<Product> findProductsByPriceIsLessThan(int maxPrice);

    List<Product> findProductsByPriceIsBetween(int minPrice, int maxPrice);
}

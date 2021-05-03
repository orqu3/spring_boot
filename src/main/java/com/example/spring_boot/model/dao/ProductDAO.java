package com.example.spring_boot.model.dao;

import com.example.spring_boot.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    List<Product> findProductsByPriceIsGreaterThan(int minPrice);
    List<Product> findProductsByPriceIsLessThan(int maxPrice);
    List<Product> findProductsByPriceIsBetween(int minPrice, int maxPrice);

}

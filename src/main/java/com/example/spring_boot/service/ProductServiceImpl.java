package com.example.spring_boot.service;

import com.example.spring_boot.model.entity.Product;
import com.example.spring_boot.model.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;


    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Object deleteById(Long id) {
        productDAO.deleteById(id);
        return null;
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> findProductsByPriceIsGreaterThan(int minPrice) {
        return productDAO.findProductsByPriceIsGreaterThan(minPrice);
    }

    @Override
    public List<Product> findProductsByPriceIsLessThan(int maxPrice) {
        return productDAO.findProductsByPriceIsLessThan(maxPrice);
    }

    @Override
    public List<Product> findProductsByPriceIsBetween(int minPrice, int maxPrice) {
        return productDAO.findProductsByPriceIsBetween(minPrice, maxPrice);
    }
}

package com.example.spring_boot.service;

import com.example.spring_boot.dao.ProductDAO;
import com.example.spring_boot.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(PageRequest pageRequest) {
        return productDAO.findAll(pageRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductsByPriceIsGreaterThan(int minPrice) {
        return productDAO.findProductsByPriceIsGreaterThan(minPrice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductsByPriceIsLessThan(int maxPrice) {
        return productDAO.findProductsByPriceIsLessThan(maxPrice);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductsByPriceIsBetween(int minPrice, int maxPrice) {
        return productDAO.findProductsByPriceIsBetween(minPrice, maxPrice);
    }
}

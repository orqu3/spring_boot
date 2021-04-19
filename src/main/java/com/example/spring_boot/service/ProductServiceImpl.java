package com.example.spring_boot.service;

import com.example.spring_boot.model.entity.Product;
import com.example.spring_boot.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Override
    public void add_product(Product product) {
        repo.add_product(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return repo.getProductById(id);
    }
}

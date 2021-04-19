package com.example.spring_boot.model.repository;

import com.example.spring_boot.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> repo = new ArrayList<>();

    {
        Product egg = new Product();
        egg.setId(1);
        egg.setTitle("Egg");
        egg.setCost(10);
        repo.add(egg);

        Product milk = new Product();
        milk.setId(2);
        milk.setTitle("Milk");
        milk.setCost(20);
        repo.add(milk);

        Product bread = new Product();
        bread.setId(3);
        bread.setTitle("Bread");
        bread.setCost(15);
        repo.add(bread);

    }

    @Override
    public Product getProductById(int id) {
        return repo.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(repo);
    }

    @Override
    public void add_product(Product product) {
        repo.add(product);
    }
}

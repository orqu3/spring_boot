package com.example.spring_boot.service;

import com.example.spring_boot.controller.dto.CartItemsDto;
import com.example.spring_boot.entity.Product;
import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Data
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Cart {
    private Map<Product, Integer> products;

    @PostConstruct
    private void init() {
        products = new HashMap<>();
    }

    public void addProductToCart(Product product) {
        products.compute(product, (prod, count) -> count == null ? 1 : ++count);
    }

    public void removeProductFromCart(Product product) {
        products.computeIfPresent(product, (prod, count) -> count == 1 ? null : --count);
    }

    public List<CartItemsDto> getCarts() {
        return products.entrySet().stream()
                .map(entry -> new CartItemsDto(
                        entry.getKey().getId(),
                        entry.getKey().getTitle(),
                        entry.getKey().getPrice(),
                        entry.getValue()))
                .collect(Collectors.toList());
    }
}


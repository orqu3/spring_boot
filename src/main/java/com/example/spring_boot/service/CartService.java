package com.example.spring_boot.service;

import com.example.spring_boot.controller.dto.CartItemsDto;
import com.example.spring_boot.entity.Product;

import java.util.List;

public interface CartService {

    void addProductToCart(Product product);

    void removeProductFromCart(Product product);

    List<CartItemsDto> getCarts();
}

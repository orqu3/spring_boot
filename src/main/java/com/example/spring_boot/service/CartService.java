package com.example.spring_boot.service;

import com.example.spring_boot.entity.Cart;

import java.util.List;

public interface CartService {

    Cart addToCart(Cart cart);

    List<Cart> viewAllItems();

    void removeAllItems();

}

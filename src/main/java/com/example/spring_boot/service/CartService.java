package com.example.spring_boot.service;

import java.util.List;

public interface CartService {

    Cart getNewCart();

    Cart addToCart(Cart cart);

    List<Cart> viewAllItems();

    void deleteAllItems();

}

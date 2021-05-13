package com.example.spring_boot.controller;

import com.example.spring_boot.service.Cart;
import com.example.spring_boot.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartRestController {
    private final CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @GetMapping("/viewAll")
    public List<Cart> viewAllItems(){
        return cartService.viewAllItems();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllItems() {
        cartService.deleteAllItems();
    }
}

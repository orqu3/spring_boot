package com.example.spring_boot.controller;

import com.example.spring_boot.controller.dto.CartItemsDto;
import com.example.spring_boot.service.Cart;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartRestController {
    private final ProductService productService;
    private final Cart cart;


    @GetMapping("/all")
    public List<CartItemsDto> getCart() {
        return cart.getCarts();
    }

    @PostMapping("/add")
    public void addProductToCart(@RequestParam Long id) {
        cart.addProductToCart(productService.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void removeProductFromCart(@PathVariable Long id) {
        cart.removeProductFromCart(productService.findById(id).get());
    }
}
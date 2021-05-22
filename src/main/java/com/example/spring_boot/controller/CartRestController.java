package com.example.spring_boot.controller;

import com.example.spring_boot.controller.dto.CartItemsDto;
import com.example.spring_boot.service.CartService;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartRestController {
    private final ProductService productService;
    private final CartService cartService;


    @GetMapping("/all")
    public List<CartItemsDto> getCartService() {
        return cartService.getCarts();
    }

    @PostMapping("/add")
    public void addProductToCart(@RequestParam Long id) {
        cartService.addProductToCart(productService.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void removeProductFromCart(@PathVariable Long id) {
        cartService.removeProductFromCart(productService.findById(id).get());
    }
}
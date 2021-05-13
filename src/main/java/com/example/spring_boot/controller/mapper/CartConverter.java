package com.example.spring_boot.controller.mapper;

import com.example.spring_boot.controller.dto.CartDto;
import com.example.spring_boot.entity.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public CartDto fromCart(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setProduct(cart.getProduct());
        cartDto.setQuantity(cart.getQuantity());
        return cartDto;
    }
}

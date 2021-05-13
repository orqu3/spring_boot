package com.example.spring_boot.controller.dto;

import com.example.spring_boot.entity.Product;
import lombok.Data;

@Data
public class CartDto {

    private Long id;
    private Product product;
    private Long productQuantity;

}

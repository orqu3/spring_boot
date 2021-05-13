package com.example.spring_boot.controller.dto;

import lombok.Data;

@Data
public class CartDto {

    private Long id;
    private ProductDto productDto;
    private Long productQuantity;

}

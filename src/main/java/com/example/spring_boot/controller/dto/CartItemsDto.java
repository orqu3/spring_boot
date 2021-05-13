package com.example.spring_boot.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemsDto {

    private Long id;
    private String title;
    private int price;
    private Integer count;

}

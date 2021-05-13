package com.example.spring_boot.controller.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private int price;

    @Override
    public String toString() {
        return "Product " +
                "[id = " + id +
                ", title = " + title +
                ", price = " + price +
                "]";
    }
}

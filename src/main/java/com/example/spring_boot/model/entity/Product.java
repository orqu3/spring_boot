package com.example.spring_boot.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private int cost;

    @Override
    public String toString() {
        return "Product [id = " + id + ", title = " + title + ", cost = " + cost + "]";
    }
}

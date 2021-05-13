package com.example.spring_boot.controller.mapper;

import com.example.spring_boot.controller.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDto fromProduct(com.example.spring_boot.entity.Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}

package com.example.spring_boot.controller.mapper;

import com.example.spring_boot.controller.dto.ProductDto;
import com.example.spring_boot.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDto fromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}

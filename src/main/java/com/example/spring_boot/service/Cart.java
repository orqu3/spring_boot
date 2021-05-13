package com.example.spring_boot.service;

import com.example.spring_boot.entity.Product;
import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Cart {

    private Long id;
    private Product product;
    private Long quantity;

}

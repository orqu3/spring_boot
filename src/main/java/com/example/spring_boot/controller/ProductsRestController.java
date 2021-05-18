package com.example.spring_boot.controller;

import com.example.spring_boot.controller.dto.ProductDto;
import com.example.spring_boot.controller.mapper.ProductConverter;
import com.example.spring_boot.entity.Product;
import com.example.spring_boot.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsRestController {

    private final ProductService productService;
    private final ProductConverter productConverter;

    public ProductsRestController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productConverter.fromProduct(productService.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @GetMapping("/all")
    public List<ProductDto> findAll() {
        return productService.findAll().stream().map(productConverter::fromProduct).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody Product product) {
        product.setId(0L);
        return productConverter.fromProduct(productService.save(product));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ProductDto updateProduct(@RequestBody Product product) {
        return productConverter.fromProduct(productService.save(product));
    }
}

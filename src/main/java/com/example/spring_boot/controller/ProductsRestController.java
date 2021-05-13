package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsRestController {

    private final ProductService productService;

    public ProductsRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    public Product addStudent(@RequestBody Product product) {
        product.setId(0L);
        return productService.save(product);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateStudent(@RequestBody Product product) {
        return productService.save(product);
    }
}

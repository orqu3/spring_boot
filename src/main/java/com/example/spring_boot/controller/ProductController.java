package com.example.spring_boot.controller;

import com.example.spring_boot.model.entity.Product;
import com.example.spring_boot.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/all_products")
    public String getProductList(Model model) {
        model.addAttribute("all_products", productService.findAll());
        return "all_products";
    }

    @GetMapping("/add_product")
    public String getAddNewProductForm() {
        return "add_product";
    }

    @PostMapping("/add_product")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/";
    }
}


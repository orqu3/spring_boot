package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.findById(id);
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
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        model.addAttribute("delete", productService.deleteById(id));
        return "redirect:/";
    }
}


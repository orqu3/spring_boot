package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class ProductController {

    private final ProductService productService;

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
    public String getAddNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/add_product")
    public String addNewProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        this.productService.deleteById(id);
        return "redirect:/";
    }
}


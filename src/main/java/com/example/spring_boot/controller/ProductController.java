package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping({"/all_products", "/all_products/{pageId}"})
    public String getProductList(Model model, @PathVariable(required = false) Integer pageId) {
        if(pageId == null) {
            pageId = 1;
        }
        PageRequest pageRequest = PageRequest.of(pageId - 1, 10);
        final Page<Product> products = productService.findAll(pageRequest);
        model.addAttribute("products", products.getContent());
        final int pageNumber = products.getPageable().getPageNumber();
        model.addAttribute("currentPage", pageNumber + 1);
        model.addAttribute("previousPage", products.getPageable().hasPrevious() ? pageNumber : null);
        model.addAttribute("nextPage", products.getTotalPages() > pageNumber + 1 ? pageNumber + 2 : null);
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


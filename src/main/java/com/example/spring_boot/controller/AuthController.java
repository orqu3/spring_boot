package com.example.spring_boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }

}

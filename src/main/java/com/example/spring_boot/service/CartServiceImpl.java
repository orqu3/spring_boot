package com.example.spring_boot.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
//@Scope(value = WebApplicationContext.SCOPE_SESSION,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

}



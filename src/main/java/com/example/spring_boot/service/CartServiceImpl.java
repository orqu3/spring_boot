package com.example.spring_boot.service;

import com.example.spring_boot.dao.CartDAO;
import com.example.spring_boot.entity.Cart;
import com.example.spring_boot.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
//@Scope(value = WebApplicationContext.SCOPE_SESSION,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;

    @Transactional
    public Cart addToCart(Cart cart) {
        return cartDAO.save(cart);
    }

    @Transactional
        public List<Cart> viewAllItems() {
        return cartDAO.findAll();
    }

    @Transactional
    public void removeAllItems() {
        cartDAO.deleteAll();
    }
}



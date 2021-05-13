package com.example.spring_boot.service;

import com.example.spring_boot.dao.CartDAO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
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

    @Lookup
    @Transactional
    @Override
    public Cart getNewCart() {
        return null;
    }

    @Transactional
    @Override
    public Cart addToCart(Cart cart) {
        return cartDAO.save(cart);
    }

    @Transactional
    @Override
    public List<Cart> viewAllItems() {
        return cartDAO.findAll();
    }

    @Transactional
    @Override
    public void deleteAllItems() {
        cartDAO.deleteAll();
    }
}



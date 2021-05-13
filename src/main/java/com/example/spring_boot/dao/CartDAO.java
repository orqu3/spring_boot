package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<Cart, Long> {

}

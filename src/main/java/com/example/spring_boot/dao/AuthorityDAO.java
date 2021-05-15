package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDAO extends JpaRepository<Authority, Long> {
}

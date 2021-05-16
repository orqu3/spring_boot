package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}

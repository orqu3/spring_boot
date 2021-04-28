package com.example.spring_boot.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public EntityManager entityManager() {
        SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.xml").buildSessionFactory();
        return factory.createEntityManager();
    }
}

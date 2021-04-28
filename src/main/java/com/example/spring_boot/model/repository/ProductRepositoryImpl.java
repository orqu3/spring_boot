package com.example.spring_boot.model.repository;

import com.example.spring_boot.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Table(name = "products")
public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager entityManager;

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = entityManager
                .createQuery("SELECT p FROM Product p")
                .getResultList();
        return products;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        findById(product.getId());
        entityManager.getTransaction().commit();
        product.setTitle(product.getTitle());
        product.setPrice(product.getPrice());
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }
}

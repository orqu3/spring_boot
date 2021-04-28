package com.example.spring_boot.dao;

import com.example.spring_boot.entity.Product;
import com.example.spring_boot.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Table(name = "users")
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = entityManager
                .createQuery("SELECT u FROM User u")
                .getResultList();
        return users;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public User saveOrUpdate(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        findById(user.getId());
        entityManager.getTransaction().commit();
        user.setName(user.getName());
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<Product> findUserProducts(Long id) {
        User user = findById(id);
        return user.getProducts();
    }
}


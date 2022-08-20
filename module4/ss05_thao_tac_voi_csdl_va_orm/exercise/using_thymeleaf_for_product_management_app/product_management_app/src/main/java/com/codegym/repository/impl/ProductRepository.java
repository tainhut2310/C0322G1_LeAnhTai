package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findAll(String name) {
        Session session = BaseRepository.sessionFactory.openSession();
        Query query = session.createQuery("SELECT p FROM Product AS p WHERE p.name LIKE :keySearch");
        query.setParameter("keySearch", '%' + name + '%');
        return query.getResultList();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(product.getId());
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setProductDescription(product.getProductDescription());
            origin.setProducer(product.getProducer());
            session.delete(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
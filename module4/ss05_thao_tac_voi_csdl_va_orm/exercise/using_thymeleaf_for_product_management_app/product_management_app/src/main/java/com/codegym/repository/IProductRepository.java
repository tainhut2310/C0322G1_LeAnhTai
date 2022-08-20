package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    void save(Product product);

    Product findById(int id);

    List<Product> findAll(String name);

    void update(Product product);

    void remove(Product product);
}

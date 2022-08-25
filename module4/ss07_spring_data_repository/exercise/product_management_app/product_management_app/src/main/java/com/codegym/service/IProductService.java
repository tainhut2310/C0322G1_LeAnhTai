package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService<T> {

    Page<Product> findByName(String name, Pageable pageable);

    void save(Product product);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

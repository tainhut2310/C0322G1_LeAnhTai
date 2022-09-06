package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService<T> {
    List<Category> findAll();

    Page<Category> findByName(String name, Pageable pageable);

    void save(Category category);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

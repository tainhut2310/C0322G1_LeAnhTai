package com.codegym.blog_application.service.impl;

import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.repository.ICategoryRepository;
import com.codegym.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findByName(String name, Pageable pageable) {
        return categoryRepository.findByNameContaining(name, pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }
}

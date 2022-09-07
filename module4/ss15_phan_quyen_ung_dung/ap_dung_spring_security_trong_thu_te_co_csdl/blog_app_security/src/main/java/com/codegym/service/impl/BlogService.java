package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findByName(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional findById(Integer id) {
        return blogRepository.findById(id);
    }


    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }
}

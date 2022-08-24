package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService<T> {
    List<Blog> findAll();

    Page<Blog> findByName(String topic, Pageable pageable);

    void save(Blog blog);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

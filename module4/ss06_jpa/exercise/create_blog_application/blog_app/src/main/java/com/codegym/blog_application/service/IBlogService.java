package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void remove(Integer id);
}

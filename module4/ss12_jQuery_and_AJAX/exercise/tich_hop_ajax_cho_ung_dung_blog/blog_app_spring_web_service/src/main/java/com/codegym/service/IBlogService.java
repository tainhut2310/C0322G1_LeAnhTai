package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService<T> {

    Page<Blog> findByTitle(String topic, Pageable pageable);
}

package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IBookService<T> {
    List<Book> findAll();

    Optional<T> findById(Integer id);

    void save(Book book);
}

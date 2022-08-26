package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        Integer quantity = book.getQuantity() - 1;
        book.setQuantity(quantity);
        bookRepository.save(book);
    }
}

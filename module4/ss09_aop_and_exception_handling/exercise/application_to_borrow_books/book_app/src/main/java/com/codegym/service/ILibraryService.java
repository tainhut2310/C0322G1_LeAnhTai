package com.codegym.service;

import com.codegym.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ILibraryService<T> {
    Page<Library> findByName(String bookTitle, Pageable pageable);

    Optional<T> findByRentalCode(Long id);

    void remove(Long id);

    void save(Library library);
}

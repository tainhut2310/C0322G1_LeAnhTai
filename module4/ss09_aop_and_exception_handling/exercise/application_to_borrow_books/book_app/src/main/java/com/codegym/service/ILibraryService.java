package com.codegym.service;

import com.codegym.model.Library;

import java.util.Optional;

public interface ILibraryService<T> {

    Optional<T> findByRentalCode(Long id);

    void remove(Long id);

    void save(Library library);
}

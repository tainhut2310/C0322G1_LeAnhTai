package com.codegym.service.impl;

import com.codegym.model.Library;
import com.codegym.repository.ILibraryRepository;
import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService implements ILibraryService {
    @Autowired
    private ILibraryRepository libraryRepository;
    @Override
    public Page<Library> findByName(String bookTitle, Pageable pageable) {
        return null;
    }

    @Override
    public Optional findByRentalCode(Long id) {
        return libraryRepository.findByRentalCode(id);
    }

    @Override
    public void remove(Long id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
    }
}

package com.codegym.repository;

import com.codegym.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILibraryRepository extends JpaRepository<Library, Long> {
    Optional<Library> findByRentalCode(Long id);
}

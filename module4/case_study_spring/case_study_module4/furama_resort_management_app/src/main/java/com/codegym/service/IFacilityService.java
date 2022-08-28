package com.codegym.service;

import com.codegym.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService<T> {
    Page<Facility> findByName(String name, Pageable pageable);

    void save(Facility facility);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

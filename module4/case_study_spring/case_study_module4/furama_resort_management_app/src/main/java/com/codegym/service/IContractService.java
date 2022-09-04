package com.codegym.service;

import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService<T> {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

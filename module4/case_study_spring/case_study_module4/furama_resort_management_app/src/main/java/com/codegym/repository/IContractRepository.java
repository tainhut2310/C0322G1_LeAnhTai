package com.codegym.repository;

import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findByCustomerNameContaining(String name, Pageable pageable);
}



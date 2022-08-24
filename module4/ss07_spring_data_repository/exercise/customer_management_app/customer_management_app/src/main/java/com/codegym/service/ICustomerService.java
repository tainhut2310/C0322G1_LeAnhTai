package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService<T> {

    Page<Customer> findByName(String name, Pageable pageable);

    void save(Customer customer);

    Optional<T> findById(Long id);

    void remove(Long id);
}

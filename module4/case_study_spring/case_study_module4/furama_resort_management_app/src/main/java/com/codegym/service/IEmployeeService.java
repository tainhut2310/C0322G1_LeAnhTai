package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService<T> {
    Page<Employee> findByName(String name, Pageable pageable);

    List<Employee> findAll();

    void save(Employee employee);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

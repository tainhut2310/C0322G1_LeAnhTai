package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService<T> {

    Page<User> findByName(String name, Pageable pageable);

    void save(User user);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}

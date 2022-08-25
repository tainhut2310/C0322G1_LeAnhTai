package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;


    @Override
    public Page<User> findByName(String name, Pageable pageable) {
        return userRepository.findByFirstNameContaining(name, pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }
}

package com.codegym.service;

import com.codegym.model.Division;

import java.util.List;

public interface IDivisionService<T> {
    List<Division> findAll();
}

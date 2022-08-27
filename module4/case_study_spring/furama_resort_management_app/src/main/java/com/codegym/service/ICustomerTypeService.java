package com.codegym.service;

import com.codegym.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService<T> {
    public List<CustomerType> findAll();
}

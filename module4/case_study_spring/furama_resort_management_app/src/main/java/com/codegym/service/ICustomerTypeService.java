package com.codegym.service;

import com.codegym.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService<T> {
    List<CustomerType> findAll();
}

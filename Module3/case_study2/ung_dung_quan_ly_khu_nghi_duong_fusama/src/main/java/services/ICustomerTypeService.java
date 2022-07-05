package services;

import models.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    public List<CustomerType> findAll();
}

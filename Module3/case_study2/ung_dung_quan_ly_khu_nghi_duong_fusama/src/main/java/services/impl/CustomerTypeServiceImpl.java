package services.impl;

import models.CustomerType;
import repositoy.ICustomerTypeRepository;
import repositoy.impl.CustomerTypeRepositoryImpl;
import services.ICustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}

package repositoy;

import models.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    public List<CustomerType> findAll();
}

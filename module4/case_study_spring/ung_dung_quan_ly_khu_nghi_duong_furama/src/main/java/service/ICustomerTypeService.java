package service;

import model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerTypeService {
    public List<CustomerType> selectAll() throws SQLException;
}

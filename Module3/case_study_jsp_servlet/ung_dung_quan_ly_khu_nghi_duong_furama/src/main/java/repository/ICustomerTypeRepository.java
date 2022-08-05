package repository;

import model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerTypeRepository {
    public List<CustomerType> selectAll() throws SQLException;
}

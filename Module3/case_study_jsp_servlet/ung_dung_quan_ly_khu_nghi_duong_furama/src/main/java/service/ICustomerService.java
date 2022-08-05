package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public void insert(Customer customer);

    public Customer selectById(int id);

    public List<Customer> selectAll() throws SQLException;

    public boolean delete(int id);

    public boolean update(Customer customer);
}

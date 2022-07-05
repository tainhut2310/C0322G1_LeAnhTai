package services;

import models.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public List<Customer> display() throws SQLException;

    public void addNew(Customer customer);

    public Customer getCustomerById(int id);

    public boolean update(Customer customer) throws SQLException;

    public boolean delete(int id) throws SQLException;
}

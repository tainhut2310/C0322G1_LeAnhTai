package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    public boolean insert(Customer customer) throws SQLException;

    public Customer selectById(int id) throws SQLException;

    public List<Customer> selectByName(String nameSearch) throws SQLException;

    public List<Customer> selectAll() throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Customer customer) throws SQLException;
}

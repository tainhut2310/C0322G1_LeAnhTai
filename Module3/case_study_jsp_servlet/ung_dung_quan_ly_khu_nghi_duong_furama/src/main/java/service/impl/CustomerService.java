package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public boolean insert(Customer customer) throws SQLException {
        return customerRepository.insert(customer);
    }

    @Override
    public Customer selectById(int id) throws SQLException {
        return customerRepository.selectById(id);
    }

    @Override
    public List<Customer> selectByName(String nameSearch) throws SQLException {
        return customerRepository.selectByName(nameSearch);
    }

    @Override
    public List<Customer> selectAll() throws SQLException {
        return customerRepository.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return customerRepository.update(customer);
    }
}

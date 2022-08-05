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
    public void insert(Customer customer) {
        customerRepository.insert(customer);
    }

    @Override
    public Customer selectById(int id) {
        return customerRepository.selectById(id);
    }

    @Override
    public List<Customer> selectAll() throws SQLException {
        return customerRepository.selectAll();
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }
}

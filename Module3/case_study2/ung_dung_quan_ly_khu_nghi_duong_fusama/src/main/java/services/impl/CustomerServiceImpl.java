package services.impl;

import models.Customer;
import repositoy.ICustomerRepository;
import repositoy.impl.CustomerRepositoryImpl;
import services.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> display() throws SQLException {
            return customerRepository.display();
    }

    @Override
    public void addNew(Customer customer) {
        customerRepository.addNew(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        return customerRepository.update(customer);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return customerRepository.delete(id);
    }
}

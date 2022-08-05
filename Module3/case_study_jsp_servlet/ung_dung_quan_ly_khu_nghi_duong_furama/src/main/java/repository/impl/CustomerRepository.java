package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    @Override
    public void insertCustomer(Customer customer) {

    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }
}

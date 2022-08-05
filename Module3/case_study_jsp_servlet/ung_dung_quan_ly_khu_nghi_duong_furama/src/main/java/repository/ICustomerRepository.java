package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public void insertCustomer(Customer customer);

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomer();

    public boolean deleteCustomer(int id);

    public boolean updateCustomer(Customer customer);
}

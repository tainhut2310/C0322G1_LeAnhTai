package services;

import models.Customer;
import models.Employee;

import java.util.List;

public interface ICustomerService {
    public List<Customer> display();

    public Customer addNew(Customer customer);

    public Customer edit(Customer customer);

    public void delete(Customer customer);
}

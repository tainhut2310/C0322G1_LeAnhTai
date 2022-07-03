package services;

import models.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> display();

    public Employee addNew(Employee employee);

    public Employee edit(Employee employee);

    public void delete(Employee employee);
}

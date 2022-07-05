package services.impl;

import models.Employee;
import repositoy.IEmployeeRepository;
import repositoy.impl.EmployeeRepositoryImpl;
import services.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();


    @Override
    public List<Employee> display() {
        return employeeRepository.display();
    }

    @Override
    public void addNew(Employee employee) {
        employeeRepository.addNew(employee);
    }

    @Override
    public Employee edit(int id) {
        return employeeRepository.edit(id);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }
}

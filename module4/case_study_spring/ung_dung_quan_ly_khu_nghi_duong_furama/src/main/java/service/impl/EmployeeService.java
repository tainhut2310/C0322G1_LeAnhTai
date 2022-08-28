package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public boolean insert(Employee employee) throws SQLException {
        return employeeRepository.insert(employee);
    }

    @Override
    public Employee selectById(int id) throws SQLException {
        return employeeRepository.selectById(id);
    }

    @Override
    public List<Employee> selectByName(String nameSearch) throws SQLException {
        return employeeRepository.selectByName(nameSearch);
    }

    @Override
    public List<Employee> selectAll() throws SQLException {
        return employeeRepository.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return employeeRepository.delete(id);
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        return employeeRepository.update(employee);
    }
}

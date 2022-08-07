package service;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    public boolean insert(Employee employee) throws SQLException;

    public Employee selectById(int id) throws SQLException;

    public List<Employee> selectByName(String nameSearch) throws SQLException;

    public List<Employee> selectAll() throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Employee employee) throws SQLException;
}

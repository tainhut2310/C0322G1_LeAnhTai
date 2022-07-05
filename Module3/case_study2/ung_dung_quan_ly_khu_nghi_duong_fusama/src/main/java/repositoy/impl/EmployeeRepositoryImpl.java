package repositoy.impl;

import models.Customer;
import models.Employee;
import repositoy.BaseRepository;
import repositoy.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String FIND_ALL = "select * from employee;";


    @Override
    public List<Employee> display() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int position = resultSet.getInt("position_id");
                int educationDegree = resultSet.getInt("education_degree_id");
                int division = resultSet.getInt("division_id");
                employee = new Employee(id, name, dateOfBirthday, idCard, phoneNumber, email, address, position, educationDegree, division);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void addNew(Employee employee) {

    }

    @Override
    public Employee edit(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}

package repository.impl;

import model.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String SELECT_ALL = "select * from employee where flag = 0;";
    private static final String INSERT = "insert into employee (`name`, date_of_birthday, " +
            " id_card, salary, phone_number, email, address, position_id, education_degree_id, division_id ) " +
            " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "update employee set flag = 1 where id = ?;";
    private static final String SELECT_BY_ID = "select * from employee where id = ?;";
    private static final String SELECT_BY_NAME = "select * from employee where `name` like ? and flag = 0;";
    private static final String UPDATE = "update employee set `name` = ?, date_of_birthday = ?, " +
            " id_card = ?, salary = ?, phone_number = ?, email = ?, address = ?, position_id = ?, education_degree_id = ?, " +
            " division_id = ? where id = ? and flag = 0;";
    @Override
    public boolean insert(Employee employee) throws SQLException {
        boolean rowInsert;
        try (Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1, employee.getName());
            statement.setDate(2, Date.valueOf(employee.getDateOfBirthday()));
            statement.setString(3, employee.getIdCard());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPhoneNumber());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPositionId());
            statement.setInt(9, employee.getEducationDegreeId());
            statement.setInt(10, employee.getDivisionId());
            rowInsert = statement.executeUpdate() > 0;
        }
        return rowInsert;
    }

    @Override
    public Employee selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Employee> selectByName(String nameSearch) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME);) {
            statement.setString(1, '%' + nameSearch + '%');
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                employeeList.add(new Employee(id, name, dateOfBirthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId));
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> selectAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                employeeList.add(new Employee(id, name, dateOfBirthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId));
            }
        }
        return employeeList;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE) ){
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, employee.getName());
            statement.setDate(2, Date.valueOf(employee.getDateOfBirthday()));
            statement.setString(3, employee.getIdCard());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPhoneNumber());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPositionId());
            statement.setInt(9, employee.getEducationDegreeId());
            statement.setInt(10, employee.getDivisionId());
            statement.setInt(11, employee.getId());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}

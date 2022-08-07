package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.*;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL = "select * from customer where flag = 0;";
    private static final String INSERT = "insert into customer (`name`, date_of_birthday, " +
            " gender, id_card, phone_number, email, address, customer_type_id ) " +
            " values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "update customer set flag = 1 where id = ?;";
    private static final String SELECT_BY_ID = "select * from customer where id = ? and flag = 0;";
    private static final String SELECT_BY_NAME = "select * from customer where `name` like ?;";
    private static final String UPDATE = "update customer set `name` = ?, date_of_birthday = ?, gender = ?, " +
            " id_card = ?, phone_number = ?, email = ?, address = ?, customer_type_id = ? where id = ? and flag = 0;";

    @Override
    public boolean insert(Customer customer) throws SQLException {
        boolean rowInsert;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, customer.getName());
            statement.setDate(2, Date.valueOf(customer.getDateOfBirthday()));
            statement.setInt(3, customer.getGender());
            statement.setString(4, customer.getIdCard());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.setInt(8, customer.getCustomerTypeId());
            rowInsert = statement.executeUpdate() > 0;
        }
        return rowInsert;
    }

    @Override
    public Customer selectById (int id) throws SQLException {
        Customer customer = null;
        try (Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCutomer = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customer = new Customer(idCutomer, name, dateOfBirthday, gender, idCard, phoneNumber, email, address, customerTypeId);
            }
            return customer;
        }
    }

    @Override
    public List<Customer> selectByName(String nameSearch) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME);) {
            statement.setString(1,'%' + nameSearch + '%' );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(id, name, dateOfBirthday, gender, idCard, phoneNumber, email, address, customerTypeId));
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> selectAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int customerTypeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(id, name, dateOfBirthday, gender, idCard, phoneNumber, email, address, customerTypeId));
            }
        }
        return customerList;
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
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, customer.getName());
            statement.setDate(2, Date.valueOf(customer.getDateOfBirthday()));
            statement.setInt(3, customer.getGender());
            statement.setString(4, customer.getIdCard());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.setInt(8, customer.getCustomerTypeId());
            statement.setInt(9, customer.getId());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}

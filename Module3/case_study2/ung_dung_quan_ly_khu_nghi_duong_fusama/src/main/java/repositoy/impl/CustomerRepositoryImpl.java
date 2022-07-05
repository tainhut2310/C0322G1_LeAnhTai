package repositoy.impl;

import models.Customer;
import repositoy.BaseRepository;
import repositoy.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    private static final String FIND_ALL = " select customer.* from customer where statuses = 0;";
    private static final String INSERT = " INSERT INTO customer (name, date_of_birthday, gender, id_card, phone_number, email, address, customer_type_id) " +
            " values( ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where id = ?;";
    private static final String UPDATE_CUSTOMER = " update customer set `name` = ?, date_of_birthday = ?, gender = ?, " +
            " id_card = ?, phone_number = ?, email = ?, address = ?, customer_type_id = ? where id = ?;";
    private static final String DELETE_CUSTOMER = "update customer set statuses = 1 where id = ?;";

    @Override
    public List<Customer> display() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirthday = resultSet.getString("date_of_birthday");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int typeOfCustomer = resultSet.getInt("customer_type_id");
                customer = new Customer(id, name, dateOfBirthday, address, idCard, phoneNumber, email, typeOfCustomer, gender);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void addNew(Customer customer) {
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, Date.valueOf(customer.getDateOfBirth()));
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setInt(8, customer.getTypeOfCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;

        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birthday");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int typeOfCustomer = resultSet.getInt("customer_type_id");
                customer = new Customer(id, name, dateOfBirth, idCard, phoneNumber, email, address, typeOfCustomer, gender);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdate;
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getDateOfBirth());
        preparedStatement.setInt(3, customer.getGender());
        preparedStatement.setString(4, customer.getIdCard());
        preparedStatement.setString(5, customer.getPhoneNumber());
        preparedStatement.setString(6, customer.getEmail());
        preparedStatement.setString(7, customer.getAddress());
        preparedStatement.setInt(8, customer.getTypeOfCustomer());
        preparedStatement.setInt(9, customer.getId());
        rowUpdate = preparedStatement.executeUpdate() > 0;

        return rowUpdate;
    }

    @Override
    public boolean delete(int id){
        boolean rowUpdate = false;
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }
}

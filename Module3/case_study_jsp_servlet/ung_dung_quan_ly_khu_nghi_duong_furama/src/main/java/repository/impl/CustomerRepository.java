package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";

    @Override
    public void insert(Customer customer) {

    }

    @Override
    public Customer selectById(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAll() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            ResultSet resultSet = preparedStatement.executeQuery();
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }
}

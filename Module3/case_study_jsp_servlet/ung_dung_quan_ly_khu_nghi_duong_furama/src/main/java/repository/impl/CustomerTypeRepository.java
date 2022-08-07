package repository.impl;

import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_ALL = "select * from customer_type;";
    @Override
    public List<CustomerType> selectAll() throws SQLException {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                customerTypeList.add(new CustomerType(id, name));
            }
        }
        return customerTypeList;
    }
}

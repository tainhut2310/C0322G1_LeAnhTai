package repository.impl;

import model.CustomerType;
import model.Division;
import repository.BaseRepository;
import repository.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private static final String SELECT_ALL = "select * from division;";

    @Override
    public List<Division> selectAll() throws SQLException {
        List<Division> divisionList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                divisionList.add(new Division(id, name));
            }
        }
        return divisionList;
    }
}

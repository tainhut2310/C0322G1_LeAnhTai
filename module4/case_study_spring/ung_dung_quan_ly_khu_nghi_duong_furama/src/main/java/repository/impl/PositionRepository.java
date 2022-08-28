package repository.impl;

import model.Position;
import repository.BaseRepository;
import repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private static final String SELECT_ALL = "select * from position;";
    @Override
    public List<Position> selectAll() throws SQLException {
        List<Position> positionList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                positionList.add(new Position(id, name));
            }
        }
        return positionList;
    }
}

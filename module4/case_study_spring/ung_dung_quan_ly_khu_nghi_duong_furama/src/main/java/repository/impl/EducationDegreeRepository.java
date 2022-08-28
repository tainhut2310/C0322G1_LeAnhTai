package repository.impl;

import model.CustomerType;
import model.EducationDegree;
import repository.BaseRepository;
import repository.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private static final String SELECT_ALL = "select * from education_degree;";

    @Override
    public List<EducationDegree> selectAll() throws SQLException {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                educationDegreeList.add(new EducationDegree(id, name));
            }
        }
        return educationDegreeList;
    }
}

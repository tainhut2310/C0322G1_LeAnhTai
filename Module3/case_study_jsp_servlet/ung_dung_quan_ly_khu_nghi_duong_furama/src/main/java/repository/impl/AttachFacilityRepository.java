package repository.impl;

import model.AttachFacility;
import repository.BaseRepository;
import repository.IAttachFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachFacilityRepository implements IAttachFacilityRepository {
    private static final String SELECT_ALL = "select * from attach_facility;";
    @Override
    public List<AttachFacility> selectAll() throws SQLException {
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("cost");
                String unit = resultSet.getString("unit");
                String status = resultSet.getString("status");
                attachFacilityList.add(new AttachFacility(id, name, cost, unit, status));
            }
        }
        return attachFacilityList;
    }
}

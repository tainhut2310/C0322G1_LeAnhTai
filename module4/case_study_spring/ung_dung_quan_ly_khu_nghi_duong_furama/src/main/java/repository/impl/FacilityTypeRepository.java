package repository.impl;

import model.FacilityType;
import repository.BaseRepository;
import repository.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepository implements IFacilityTypeRepository {
    private static final String SELECT_ALL = "select * from facility_type;";
    @Override
    public List<FacilityType> selectAll() throws SQLException {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                facilityTypeList.add(new FacilityType(id, name));
            }
        }
        return facilityTypeList;
    }
}

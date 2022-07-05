package repositoy.impl;

import models.FacilityType;
import repositoy.BaseRepository;
import repositoy.IFacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepositoryImpl implements IFacilityTypeRepository {
    private static final String FIND_ALL = "select * from facility_type;";
    @Override
    public List<FacilityType> findAll() {
        List<FacilityType> facilityTypeList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            FacilityType facilityType = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                facilityType = new FacilityType(id, name);
                facilityTypeList.add(facilityType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityTypeList;
    }
}

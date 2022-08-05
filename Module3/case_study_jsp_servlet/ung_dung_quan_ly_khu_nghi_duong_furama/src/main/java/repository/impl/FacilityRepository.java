package repository.impl;

import model.Facility;
import repository.BaseRepository;
import repository.IFacilityRepository;
import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String SELECT_ALL_FACILITY = "select * from facility;";

    @Override
    public void insertFacility(Facility facility) {

    }

    @Override
    public Facility selectFacility(int id) {
        return null;
    }

    @Override
    public List<Facility> selectAllFacility() throws SQLException {
        List<Facility> facilityList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                facilityList.add(new Facility(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId));
            }
        }
        return facilityList;
    }

    @Override
    public boolean deleteFacility(int id) {
        return false;
    }

    @Override
    public boolean updateFacility(Facility facility) {
        return false;
    }
}

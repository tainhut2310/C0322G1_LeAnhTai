package repositoy.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import repositoy.BaseRepository;
import repositoy.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepositoryImpl implements IFacilityRepository {
    private static final String FIND_ALL = " select ft.id, f.`name`, f.`area`, f.cost, f.max_people, rt.`name` as rent_type, f.standard_room, f.description_other_convenience, f.pool_area, f.number_of_floors, f.facility_free from facility f " +
    " join rent_type rt on f.rent_type_id = rt.id " +
    " join facility_type ft on f.facility_type_id = ft.id;";

    @Override
    public List<Facility> display() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Villa villa = null;
            House house = null;
            Room room = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String rentType = resultSet.getString("rent_type");
                if(id == 1){
                    String standardRoom = resultSet.getString("standard_room");
                    String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                    double areaPool = resultSet.getDouble("pool_area");
                    int numberOfFloors = resultSet.getInt("number_of_floors");
                    villa = new Villa(id, name, area, cost, maxPeople, rentType, standardRoom, descriptionOtherConvenience, areaPool, numberOfFloors );
                    facilityList.add(villa);
                } else if (id == 2) {
                    String standardRoom = resultSet.getString("standard_room");
                    String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                    int numberOfFloors = resultSet.getInt("number_of_floors");
                    house = new House(id, name, area, cost, maxPeople, rentType, standardRoom, descriptionOtherConvenience, numberOfFloors);
                    facilityList.add(house);
                } else {
                    String facilityFree = resultSet.getString("facility_free");
                    room = new Room(id, name, area, cost, maxPeople, rentType, facilityFree);
                    facilityList.add(room);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public void addNewVilla(Villa villa) {

    }

    @Override
    public void addNewHouse(House house) {

    }

    @Override
    public void addNewRoom(Room room) {

    }

    @Override
    public Facility edit(int id) {
        return null;
    }

    @Override
    public Facility delete(int id) {
        return null;
    }
}

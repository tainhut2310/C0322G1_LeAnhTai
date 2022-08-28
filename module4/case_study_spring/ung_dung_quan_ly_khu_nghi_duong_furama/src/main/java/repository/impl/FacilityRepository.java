package repository.impl;

import model.Facility;
import repository.BaseRepository;
import repository.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String SELECT_ALL_FACILITY = "select * from facility where flag = 0;";
    private static final String INSERT = "insert into facility (`name`, `area`, cost, max_people, " +
            " standard_room, description_other_convenience, pool_area, number_of_floors, facility_free, " +
            " rent_type_id, facility_type_id) " +
            " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "update facility set flag = 1 where id = ?;";
    private static final String SELECT_BY_ID = "select * from facility where id = ? and flag = 0;";
    private static final String SELECT_BY_NAME = "select * from facility where `name` like ?;";
    private static final String UPDATE = "update facility set `name` = ?, `area` = ?, cost = ?, max_people = ?, " +
            " standard_room = ?, description_other_convenience = ?, pool_area = ?, number_of_floors = ?, facility_free = ?, " +
            " rent_type_id = ?, facility_type_id = ? where id = ? and flag = 0; ";


    @Override
    public boolean insert(Facility facility) throws SQLException {
        boolean rowInsert;
        try (Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1, facility.getName());
            statement.setInt(2, facility.getArea());
            statement.setDouble(3, facility.getCost());
            statement.setInt(4, facility.getMaxPeople());
            statement.setString(5, facility.getStandardRoom());
            statement.setString(6, facility.getDescriptionOtherConvenience());
            statement.setDouble(7, facility.getPoolArea());
            statement.setInt(8, facility.getNumberOfFloors());
            statement.setString(9, facility.getFacilityFree());
            statement.setInt(10, facility.getRentTypeId());
            statement.setInt(11, facility.getFacilityTypeId());
            rowInsert = statement.executeUpdate() > 0;
        }
        return rowInsert;
    }

    @Override
    public Facility selectById(int id) throws SQLException {
        Facility facility = null;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idFacility = resultSet.getInt("id");
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
                facility = new Facility(idFacility, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId);
            }
        }
        return facility;
    }

    @Override
    public List<Facility> selectByName(String nameSearch) throws SQLException {
        List<Facility> facilityList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME)){
            statement.setString(1, '%' + nameSearch + '%');
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
    public List<Facility> selectAll() throws SQLException {
        List<Facility> facilityList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FACILITY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean update(Facility facility) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)){
            statement.setString(1, facility.getName());
            statement.setInt(2, facility.getArea());
            statement.setDouble(3, facility.getCost());
            statement.setInt(4, facility.getMaxPeople());
            statement.setString(5, facility.getStandardRoom());
            statement.setString(6, facility.getDescriptionOtherConvenience());
            statement.setDouble(7, facility.getPoolArea());
            statement.setInt(8, facility.getNumberOfFloors());
            statement.setString(9, facility.getFacilityFree());
            statement.setInt(10, facility.getRentTypeId());
            statement.setInt(11, facility.getFacilityTypeId());
            statement.setInt(12, facility.getId());
            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}

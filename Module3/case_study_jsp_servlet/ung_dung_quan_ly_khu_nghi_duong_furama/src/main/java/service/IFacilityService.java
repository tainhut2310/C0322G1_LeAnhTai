package service;

import model.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityService {
    public void insertFacility(Facility facility);

    public Facility selectFacility(int id);

    public List<Facility> selectAllFacility() throws SQLException;

    public boolean deleteFacility(int id);

    public boolean updateFacility(Facility facility);
}

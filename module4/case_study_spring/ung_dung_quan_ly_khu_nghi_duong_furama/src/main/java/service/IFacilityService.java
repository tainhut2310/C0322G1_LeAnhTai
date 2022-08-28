package service;

import model.Facility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IFacilityService {
    public Map<String, String> insert(Facility facility) throws SQLException;

    public Facility selectById(int id) throws SQLException;

    public List<Facility> selectByName(String nameSearch) throws SQLException;

    public List<Facility> selectAll() throws SQLException;

    public boolean delete(int id) throws SQLException;

    public boolean update(Facility facility) throws SQLException;
}

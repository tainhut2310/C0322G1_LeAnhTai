package service;

import model.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityService {
    public void insert(Facility facility);

    public Facility selectById(int id);

    public List<Facility> selectAll() throws SQLException;

    public boolean delete(int id);

    public boolean update(Facility facility);
}

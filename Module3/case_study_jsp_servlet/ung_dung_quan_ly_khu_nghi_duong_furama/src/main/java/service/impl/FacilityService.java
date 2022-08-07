package service.impl;

import model.Facility;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public boolean insert(Facility facility) throws SQLException {
        return facilityRepository.insert(facility);
    }

    @Override
    public Facility selectById(int id) throws SQLException {
        return facilityRepository.selectById(id);
    }

    @Override
    public List<Facility> selectByName(String nameSearch) throws SQLException {
        return facilityRepository.selectByName(nameSearch);
    }

    @Override
    public List<Facility> selectAll() throws SQLException {
        return facilityRepository.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return facilityRepository.delete(id);
    }

    @Override
    public boolean update(Facility facility) throws SQLException {
        return facilityRepository.update(facility);
    }
}

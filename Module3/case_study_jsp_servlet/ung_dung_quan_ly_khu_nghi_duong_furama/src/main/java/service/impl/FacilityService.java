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
    public void insert(Facility facility) {
        facilityRepository.insert(facility);
    }

    @Override
    public Facility selectById(int id) {
        return facilityRepository.selectById(id);
    }

    @Override
    public List<Facility> selectAll() throws SQLException {
        return facilityRepository.selectAll();
    }

    @Override
    public boolean delete(int id) {
        return facilityRepository.delete(id);
    }

    @Override
    public boolean update(Facility facility) {
        return facilityRepository.update(facility);
    }
}

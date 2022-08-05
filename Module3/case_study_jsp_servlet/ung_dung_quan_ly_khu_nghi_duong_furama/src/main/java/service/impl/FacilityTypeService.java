package service.impl;

import model.FacilityType;
import repository.IFacilityTypeRepository;
import repository.impl.FacilityTypeRepository;
import service.IFacilityTypeService;

import java.sql.SQLException;
import java.util.List;

public class FacilityTypeService implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepository();
    @Override
    public List<FacilityType> selectAllFacilityType() throws SQLException {
        return facilityTypeRepository.selectAllFacilityType();
    }
}

package services.impl;

import models.FacilityType;
import repositoy.IFacilityTypeRepository;
import repositoy.impl.FacilityTypeRepositoryImpl;
import services.IFacilityTypeService;

import java.util.List;

public class FacilityTypeServiceImpl implements IFacilityTypeService {
    private IFacilityTypeRepository facilityTypeRepository = new FacilityTypeRepositoryImpl();
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}

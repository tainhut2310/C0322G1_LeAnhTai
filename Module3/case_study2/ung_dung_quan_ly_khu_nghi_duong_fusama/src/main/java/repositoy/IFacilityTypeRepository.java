package repositoy;

import models.FacilityType;

import java.util.List;

public interface IFacilityTypeRepository {
    public List<FacilityType> findAll();
}

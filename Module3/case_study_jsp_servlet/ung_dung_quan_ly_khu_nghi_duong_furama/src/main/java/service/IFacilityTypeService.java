package service;

import model.FacilityType;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityTypeService {
    public List<FacilityType> selectAllFacilityType() throws SQLException;
}

package repository;

import model.FacilityType;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityTypeRepository {
    public List<FacilityType> selectAll() throws SQLException;
}

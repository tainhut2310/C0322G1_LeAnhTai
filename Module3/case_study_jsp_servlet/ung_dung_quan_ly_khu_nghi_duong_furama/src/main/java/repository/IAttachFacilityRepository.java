package repository;

import model.AttachFacility;

import java.sql.SQLException;
import java.util.List;

public interface IAttachFacilityRepository {
    public List<AttachFacility> selectAll() throws SQLException;
}

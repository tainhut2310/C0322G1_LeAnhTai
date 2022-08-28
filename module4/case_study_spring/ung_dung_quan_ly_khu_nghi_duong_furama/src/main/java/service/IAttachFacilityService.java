package service;

import model.AttachFacility;

import java.sql.SQLException;
import java.util.List;

public interface IAttachFacilityService {
    public List<AttachFacility> selectAll() throws SQLException;
}

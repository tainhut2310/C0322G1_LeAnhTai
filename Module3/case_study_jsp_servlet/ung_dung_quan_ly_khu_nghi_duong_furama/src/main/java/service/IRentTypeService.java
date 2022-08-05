package service;

import model.RentType;

import java.sql.SQLException;
import java.util.List;

public interface IRentTypeService {
    public List<RentType> selectAllRentType() throws SQLException;
}

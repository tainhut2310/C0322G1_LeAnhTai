package repository;

import model.RentType;

import java.sql.SQLException;
import java.util.List;

public interface IRentTypeRepository {
    public List<RentType> selectAllRentType() throws SQLException;
}

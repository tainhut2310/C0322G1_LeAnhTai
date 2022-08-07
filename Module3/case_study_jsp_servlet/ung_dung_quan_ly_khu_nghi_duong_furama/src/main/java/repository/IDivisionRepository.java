package repository;

import model.Division;

import java.sql.SQLException;
import java.util.List;

public interface IDivisionRepository {
    public List<Division> selectAll() throws SQLException;

}

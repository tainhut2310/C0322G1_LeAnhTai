package service;

import model.Division;

import java.sql.SQLException;
import java.util.List;

public interface IDivisionService {
    public List<Division> selectAll() throws SQLException;
}

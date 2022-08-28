package service;

import model.Position;

import java.sql.SQLException;
import java.util.List;

public interface IPositionService {
    public List<Position> selectAll() throws SQLException;
}

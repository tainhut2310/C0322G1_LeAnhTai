package repository;

import model.Position;

import java.sql.SQLException;
import java.util.List;

public interface IPositionRepository {
    public List<Position> selectAll() throws SQLException;
}

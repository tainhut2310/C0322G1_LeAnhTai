package service.impl;

import model.Position;
import repository.IPositionRepository;
import repository.impl.PositionRepository;
import service.IPositionService;

import java.sql.SQLException;
import java.util.List;

public class PositionService implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepository();
    @Override
    public List<Position> selectAll() throws SQLException {
        return positionRepository.selectAll();
    }
}

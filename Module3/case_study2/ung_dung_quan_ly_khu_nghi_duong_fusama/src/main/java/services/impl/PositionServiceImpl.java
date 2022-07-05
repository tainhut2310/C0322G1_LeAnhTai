package services.impl;

import models.Position;
import repositoy.IPositionRepository;
import repositoy.impl.PositionRepositoryImpl;
import services.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}

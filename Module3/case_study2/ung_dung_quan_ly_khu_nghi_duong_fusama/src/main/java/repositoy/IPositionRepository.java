package repositoy;

import models.Position;

import java.util.List;

public interface IPositionRepository {
    public List<Position> findAll();
}

package service.impl;

import model.RentType;
import repository.IRentTypeRepository;
import repository.impl.RentTypeRepository;
import service.IRentTypeService;

import java.sql.SQLException;
import java.util.List;

public class RentTypeService implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> selectAllRentType() throws SQLException {
        return rentTypeRepository.selectAllRentType();
    }
}

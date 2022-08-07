package service.impl;

import model.Division;
import repository.IDivisionRepository;
import repository.impl.DivisionRepository;
import service.IDivisionService;

import java.sql.SQLException;
import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public List<Division> selectAll() throws SQLException {
        return divisionRepository.selectAll();
    }
}

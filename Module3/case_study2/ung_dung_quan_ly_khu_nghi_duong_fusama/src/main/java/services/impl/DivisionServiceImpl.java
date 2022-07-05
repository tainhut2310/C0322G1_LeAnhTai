package services.impl;

import models.Division;
import repositoy.IDivisionRepository;
import repositoy.impl.DivisionRepositoryImpl;
import services.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    private IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}

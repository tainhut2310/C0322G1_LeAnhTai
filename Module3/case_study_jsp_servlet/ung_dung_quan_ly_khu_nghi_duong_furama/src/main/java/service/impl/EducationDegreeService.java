package service.impl;

import model.EducationDegree;
import repository.IEducationDegreeRepository;
import repository.impl.EducationDegreeRepository;
import service.IEducationDegreeService;

import java.sql.SQLException;
import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> selectAll() throws SQLException {
        return educationDegreeRepository.selectAll();
    }
}

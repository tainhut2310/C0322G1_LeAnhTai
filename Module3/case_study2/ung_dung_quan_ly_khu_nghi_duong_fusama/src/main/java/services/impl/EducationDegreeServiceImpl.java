package services.impl;

import models.EducationDegree;
import repositoy.IEducationDegreeRepository;
import repositoy.impl.EducationDegreeRepositoryImpl;
import services.IEducationDegreeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}

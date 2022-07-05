package repositoy;

import models.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    public List<EducationDegree> findAll();
}

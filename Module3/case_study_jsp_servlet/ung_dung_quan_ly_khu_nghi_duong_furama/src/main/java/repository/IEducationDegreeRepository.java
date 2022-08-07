package repository;

import model.EducationDegree;

import java.sql.SQLException;
import java.util.List;

public interface IEducationDegreeRepository {
    public List<EducationDegree> selectAll() throws SQLException;

}

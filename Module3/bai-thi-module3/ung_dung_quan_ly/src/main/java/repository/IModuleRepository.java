package repository;

import model.Module;

import java.sql.SQLException;
import java.util.List;

public interface IModuleRepository {
    List<Module> selectAll() throws SQLException;
}

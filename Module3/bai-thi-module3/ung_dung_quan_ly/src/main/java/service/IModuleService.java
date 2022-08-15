package service;

import model.Module;

import java.sql.SQLException;
import java.util.List;

public interface IModuleService {
    List<Module> selectAll() throws SQLException;
}

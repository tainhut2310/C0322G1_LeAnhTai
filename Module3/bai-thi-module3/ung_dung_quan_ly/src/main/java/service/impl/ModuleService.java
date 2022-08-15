package service.impl;

import model.Module;
import repository.IModuleRepository;
import repository.impl.ModuleRepository;
import service.IModuleService;

import java.sql.SQLException;
import java.util.List;

public class ModuleService implements IModuleService {
    private IModuleRepository moduleRepository = new ModuleRepository();
    @Override
    public List<Module> selectAll() throws SQLException {
        return moduleRepository.selectAll();
    }
}

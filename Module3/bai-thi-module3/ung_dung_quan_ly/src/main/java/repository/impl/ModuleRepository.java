package repository.impl;

import model.BaiHoc;
import model.Module;
import repository.BaseRepository;
import repository.IModuleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuleRepository implements IModuleRepository {
    private static final String SELECT_ALL = "select * from module;";
    @Override
    public List<Module> selectAll() throws SQLException {
        List<Module> moduleList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String maModule = resultSet.getString("ma_module");
                int maKhoaHoc = resultSet.getInt("ma_khoa_hoc");
                String tenModule = resultSet.getString("ten_module");
                moduleList.add(new Module(id, maModule, maKhoaHoc, tenModule));
            }
        }
        return moduleList;
    }
}

package service;

import models.HoKhau;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IBenhAnService {
    List<HoKhau> display() throws SQLException;

    Map<String, String> addNew(HoKhau hoKhau) throws SQLException;

    HoKhau showEditForm(String id) throws SQLException;

    void edit(HoKhau hoKhau) throws SQLException;

    HoKhau showDelete(String id) throws SQLException;

    void delete(String id) throws SQLException;

    List<HoKhau> search(String nameSearch) throws SQLException;
}

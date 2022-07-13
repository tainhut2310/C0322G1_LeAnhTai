package repository.impl;

import models.HoKhau;
import repository.BaseRepository;
import repository.IBenhAnRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements IBenhAnRepository {
    private static final String SELECT_ALL = "select * from benh_an where statuses = 0;";
    private static final String INSERT_BENH_AN = "insert into benh_an (id, ngay_nhap_vien, ngay_ra_vien, ly_do_nhap_vien, id_benh_nhan) " +
            " value (?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "select * from benh_an where id like ?;";

    private static final String UPDATE_BENH_AN = "update benh_an set ngay_nhap_vien = ?, ngay_ra_vien = ?, ly_do_nhap_vien = ? where id = ?;";

    private static final String DELETE_BENH_AN = "update benh_an set statuses = 1 where id = ?;";

    private static final String SEARCH = "select * from benh_an where id like ?;";
    @Override
    public List<HoKhau> display() throws SQLException {
        List<HoKhau> hoKhauList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        HoKhau hoKhau = null;
        while(resultSet.next()) {
            String id = resultSet.getString("id");
            String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
            String ngayRaVien = resultSet.getString("ngay_ra_vien");
            String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
            String idBenhNhan = resultSet.getString("id_benh_nhan");
            hoKhau = new HoKhau(id, ngayNhapVien, ngayRaVien, lyDoNhapVien, idBenhNhan );
            hoKhauList.add(hoKhau);
        }
        return hoKhauList;
    }

    @Override
    public void addNew(HoKhau hoKhau) throws SQLException {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BENH_AN);
        preparedStatement.setString(1, hoKhau.getIdBenhAn());
        preparedStatement.setDate(2, Date.valueOf(hoKhau.getNgayNhapVien()));
        preparedStatement.setDate(3, Date.valueOf(hoKhau.getNgayRaVien()));
        preparedStatement.setString(4, hoKhau.getLyDoNhapVien());
        preparedStatement.setString(5, hoKhau.getIdBenhNhan());
        preparedStatement.executeUpdate();
    }

    @Override
    public HoKhau showEditForm(String id) throws SQLException {
        HoKhau hoKhau = null;
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setString(1, '%' + id + '%');
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String idBenhAn = resultSet.getString("id");
            String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
            String ngayRaVien = resultSet.getString("ngay_ra_vien");
            String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
            String idBenhNhan = resultSet.getString("id_benh_nhan");
            hoKhau = new HoKhau(idBenhAn, ngayNhapVien, ngayRaVien, lyDoNhapVien, idBenhNhan);
        }
        return hoKhau;
    }

    @Override
    public void edit(HoKhau hoKhau) throws SQLException {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENH_AN);
        preparedStatement.setDate(1, Date.valueOf(hoKhau.getNgayNhapVien()));
        preparedStatement.setDate(2, Date.valueOf(hoKhau.getNgayRaVien()));
        preparedStatement.setString(3, hoKhau.getLyDoNhapVien());
        preparedStatement.setString(4, hoKhau.getIdBenhAn());
        preparedStatement.executeUpdate();
    }

    @Override
    public HoKhau showDelete(String id) throws SQLException {
        return null;
    }

    @Override
    public void delete(String id) throws SQLException {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BENH_AN);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<HoKhau> search(String nameSearch) throws SQLException {
        List<HoKhau> hoKhauList = new ArrayList<>();
        HoKhau hoKhau = null;
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
        preparedStatement.setString(1, '%' + nameSearch + '%');
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String idBenhAn = resultSet.getString("id");
            String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
            String ngayRaVien = resultSet.getString("ngay_ra_vien");
            String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
            String idBenhNhan = resultSet.getString("id_benh_nhan");
            hoKhau = new HoKhau(idBenhAn, ngayNhapVien, ngayRaVien, lyDoNhapVien, idBenhNhan);
            hoKhauList.add(hoKhau);
        }
        return hoKhauList;
    }
}

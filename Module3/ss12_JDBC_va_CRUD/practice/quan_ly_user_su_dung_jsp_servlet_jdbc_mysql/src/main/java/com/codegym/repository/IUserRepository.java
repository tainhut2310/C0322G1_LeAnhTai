package com.codegym.repository;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> findByCountry (String nameCountry) throws SQLException;

    public List<User> sortByName() throws SQLException;

    public User getUserByIdStore(int id) throws SQLException;

    public void insertUserStore(User user) throws SQLException;

    public void addUserTransaction(User user, int[] permision) throws SQLException;

    public void insertUpdateWithoutTransaction() throws SQLException;

    public void insertUpdateUseTransaction() throws SQLException;

    public List<User> selectAllUserStore() throws SQLException;

    public void updateUserStore(User user) throws SQLException;

    public void deleteUserByIdStore(int id) throws SQLException;

}

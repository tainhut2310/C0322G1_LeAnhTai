package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.impl.UserRepository;
import com.codegym.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepository userRepository = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String nameCountry) throws SQLException {
        return userRepository.findByCountry(nameCountry);
    }

    @Override
    public List<User> sortByName() throws SQLException {
        return userRepository.sortByName();
    }

    @Override
    public User getUserByIdStore(int id) throws SQLException {
        return userRepository.getUserByIdStore(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        userRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) throws SQLException {
        userRepository.addUserTransaction(user, permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() throws SQLException {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() throws SQLException {
        userRepository.insertUpdateUseTransaction();
    }

    @Override
    public List<User> selectAllUserStore() throws SQLException {
        return userRepository.selectAllUserStore();
    }

    @Override
    public void updateUserStore(User user) throws SQLException {
        userRepository.updateUserStore(user);
    }

    @Override
    public void deleteUserByIdStore(int id) throws SQLException {
        userRepository.deleteUserByIdStore(id);
    }
}

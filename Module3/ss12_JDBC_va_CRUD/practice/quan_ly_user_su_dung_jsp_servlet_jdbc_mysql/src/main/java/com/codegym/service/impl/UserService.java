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
    public User getUserById(int id) throws SQLException {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUserStore(user);
    }
}

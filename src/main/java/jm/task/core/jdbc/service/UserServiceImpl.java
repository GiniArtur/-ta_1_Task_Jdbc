package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        try (Connection connection = Util.getConnection()) {
            userDao.dropUsersTable();
            System.out.println("User table dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection()) {
            userDao.saveUser(name, lastName, age);
            System.out.println("Save new user - " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection()) {
            userDao.removeUserById(id);
            System.out.println("Remove user " + id);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = List.of();
        try (Connection connection = Util.getConnection()) {
            System.out.println("table user IS exists");
            users = userDao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection()) {
            userDao.cleanUsersTable();
            System.out.println("User table cleaned");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



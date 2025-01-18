package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();


   public boolean tableExists(Connection connection, String users) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, users, new String[]{"TABLE"});

        return resultSet.next();
    }

    @Override

    public void createUsersTable() throws SQLException {


        userDao.createUsersTable();

    }

    @Override
    public void dropUsersTable() throws SQLException {
        try (Connection connection = Util.getConnection()) {
            if (tableExists(connection, "users")) {
                userDao.dropUsersTable();
                System.out.println("Users table dropped");
            }
            if (!tableExists(connection, "users")) {
                System.out.println("Users table IS NOT exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try (Connection connection = Util.getConnection()) {
            if (tableExists(connection, "users")) {
                userDao.saveUser(name, lastName, age);
                System.out.println("Save new user - " + name);
            }
            if (!tableExists(connection, "users")) {
                System.out.println(" table users IS NOT exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        try (Connection connection = Util.getConnection()) {

            if (!tableExists(connection, "users")) {

                userDao.removeUserById(id);
                System.out.println("Remove user " + id);
            }
            if (tableExists(connection, "users")) {
                System.out.println(" table users IS NOT exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = List.of();

        try (Connection connection = Util.getConnection()) {
            if (tableExists(connection, "users")) {
                System.out.println("table users IS exists");
                users = userDao.getAllUsers();
            }
            if (!tableExists(connection, "users")) {
                System.out.println(" table users IS NOT exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public void cleanUsersTable() throws SQLException {
        try (Connection connection = Util.getConnection()) {

            if (tableExists(connection, "users")) {
                userDao.cleanUsersTable();
                System.out.println("Users table cleaned");
            }
            if (!tableExists(connection, "users")) {
                System.out.println(" table users IS NOT exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



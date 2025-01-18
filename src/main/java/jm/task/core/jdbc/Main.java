package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {


    public static void main(String[] args) {
        Util util = new Util();
        UserService userService = new UserServiceImpl();

        try (Connection connection = util.getConnection()) {
            System.out.println("Create table");
            userService.createUsersTable();
            userService.saveUser("Artic", "Gini", (byte) 35);
            userService.saveUser("Artic1", "Gini1", (byte) 38);
            userService.saveUser("Artic2", "Gini2", (byte) 39);
            userService.saveUser("Artic3", "Gini3", (byte) 28);
            System.out.println("Get all users ");
            System.out.println(userService.getAllUsers());
            System.out.println("Cleane table");
            userService.cleanUsersTable();
            System.out.println("Drop table");
            userService.dropUsersTable();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

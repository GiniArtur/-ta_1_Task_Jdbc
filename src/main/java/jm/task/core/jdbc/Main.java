package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println("Create table");
        userService.createUsersTable();
        userService.saveUser("Artic", "Gini", (byte) 35);
        userService.saveUser("Artic1", "Gini1", (byte) 38);
        userService.saveUser("Artic2", "Gini2", (byte) 39);
        userService.saveUser("Artic3", "Gini3", (byte) 28);
        System.out.println("Get all users ");
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}


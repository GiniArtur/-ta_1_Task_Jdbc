package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final User user1 = new User("Artic", "Gini", (byte) 54);
    private static final User user2 = new User("Artic1", "Gini1", (byte) 53);
    private static final User user3 = new User("Artic2", "Gini2", (byte) 52);
    private static final User user4 = new User("Artic3", "Gini3", (byte) 44);
    private static final User user5 = new User("Artic4", "Gini4", (byte) 34);

    public static void main(String[] args) {
        System.out.println("Create table");
        userService.createUsersTable();
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        userService.saveUser(user5.getName(), user5.getLastName(), user5.getAge());
        System.out.println("Get all users ");
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}


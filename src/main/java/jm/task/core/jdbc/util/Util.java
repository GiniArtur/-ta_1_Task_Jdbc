package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "4544120";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_Driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("Connected to database failed");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Connected to database failed");
            throw new RuntimeException(e);
        }
        return connection;
    }

}



package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
    Connection connection = null;

    try {
        Class.forName(DRIVER); // Загрузка драйвера MySQL
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Установка соединения с ба
        System.out.println("Ок");
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        System.out.println("Не ок");
    }
    return connection;
    }
}

package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Alex", "T", (byte) 38);
        {
            System.out.println("User с именем – Alex добавлен в базу данных");
        }
        userService.saveUser("Ksu", "L", (byte) 37);
        {
            System.out.println("User с именем – Ksu добавлен в базу данных");
        }
        userService.saveUser("Al", "G", (byte) 25);
        {
            System.out.println("User с именем – Al добавлен в базу данных");
        }
        userService.saveUser("Xo", "S", (byte) 28);
        {
            System.out.println("User с именем – Xo добавлен в базу данных");
        }

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();





    }

}

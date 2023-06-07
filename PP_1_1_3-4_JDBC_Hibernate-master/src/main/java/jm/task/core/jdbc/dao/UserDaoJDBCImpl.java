package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.persistence.Id;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    Connection connection = getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE mydbtest (id BIGINT, name VARCHAR(30), lastName VARCHAR(30), age TINYINT)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
    public void dropUsersTable() throws SQLException {
        String sql = "DROP TABLE mydbtest";
        try {
        Statement statement = connection.createStatement();
        statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try {
            String sql = "INSERT INTO mydbtest (name, last_name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM mydbtest WHERE id = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setLong(1, id);
            int rowsDeleted = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM mydbtest";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    User user = new User();
                    long id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("lastName");
                    byte age = resultSet.getByte("age");
                    users.add(user);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        try {
            String sql = "DELETE FROM mydbtest";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}

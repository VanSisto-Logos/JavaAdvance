package com.vansisto.jdbc.services.impl;

import com.vansisto.jdbc.MySQLConnector;
import com.vansisto.jdbc.dao.User;
import com.vansisto.jdbc.services.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceImpl implements UserService {
    private Connection connection = MySQLConnector.getConnection();

    @Override
    public void persistUser(User user) {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO users(name) VALUES(?)")) {
            statement.setString(1, user.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void updateUser(User user) {
        try(PreparedStatement statement = connection.prepareStatement("UPDATE users SET name = ? WHERE id = ?")) {
            statement.setString(1, user.getName());
            statement.setLong(2, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printAllUsers() {
        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"));
                System.out.println(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

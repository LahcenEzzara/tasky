package com.lahcencodes.tasky.dao;

import com.lahcencodes.tasky.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String URL = "jdbc:mysql://localhost:3306/tasky_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
            while (resultSet.next()) {
                User user = new User();
                user.id = resultSet.getInt("id");
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
        return users;
    }

    public void createUser(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (name, email) VALUES (?, ?)")) {
            preparedStatement.setString(1, user.name);
            preparedStatement.setString(2, user.email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET name = ?, email = ? WHERE id = ?")) {
            preparedStatement.setString(1, user.name);
            preparedStatement.setString(2, user.email);
            preparedStatement.setInt(3, user.id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
}
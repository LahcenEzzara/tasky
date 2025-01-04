package com.lahcencodes.tasky.dao;

import com.lahcencodes.tasky.entities.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {
    private static final String URL = "jdbc:mysql://localhost:3306/tasky_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM task")) {

            while (resultSet.next()) {
                Task task = new Task();
                task.id = resultSet.getInt("id");
                task.title = resultSet.getString("title");
                task.description = resultSet.getString("description");
                task.userId = resultSet.getInt("user_id");
                tasks.add(task);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching tasks: " + e.getMessage());
        }
        return tasks;
    }

    public void createTask(Task task) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO task (title, description, user_id) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, task.title);
            preparedStatement.setString(2, task.description);
            preparedStatement.setInt(3, task.userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating task: " + e.getMessage());
        }
    }

    public void updateTask(Task task) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE task SET title = ?, description = ?, user_id = ? WHERE id = ?")) {

            preparedStatement.setString(1, task.title);
            preparedStatement.setString(2, task.description);
            preparedStatement.setInt(3, task.userId);
            preparedStatement.setInt(4, task.id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    public void deleteTask(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM task WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }
}

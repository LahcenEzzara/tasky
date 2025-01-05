package com.lahcencodes.tasky.services;

import com.lahcencodes.tasky.entities.Task;

import java.util.List;

/**
 * Service interface for managing tasks.
 * This interface defines the methods for task-related operations.
 */
public interface TaskService {
    List<Task> getAllTasks();

    void createTask(Task task);

    void updateTask(Task task);

    void deleteTask(int id);
}
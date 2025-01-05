package com.lahcencodes.tasky.services;

import com.lahcencodes.tasky.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    void createTask(Task task);

    void updateTask(Task task);

    void deleteTask(int id);
}
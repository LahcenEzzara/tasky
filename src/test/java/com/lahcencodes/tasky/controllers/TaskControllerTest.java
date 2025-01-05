package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.entities.Task;
import com.lahcencodes.tasky.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks() {
        // Arrange
        Task task1 = new Task();
        task1.setId(1);
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setUserId(1);

        Task task2 = new Task();
        task2.setId(2);
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setUserId(2);

        when(taskService.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<Task> tasks = taskController.getAllTasks();

        // Assert
        assertEquals(2, tasks.size());
        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void testCreateTask() {
        // Arrange
        Task task = new Task();
        task.setId(1);
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setUserId(1);

        // Act
        taskController.createTask(task);

        // Assert
        verify(taskService, times(1)).createTask(task);
    }

    @Test
    void testUpdateTask() {
        // Arrange
        Task task = new Task();
        task.setId(1);
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setUserId(1);

        // Act
        taskController.updateTask(1, task);

        // Assert
        verify(taskService, times(1)).updateTask(task);
    }

    @Test
    void testDeleteTask() {
        // Arrange
        int taskId = 1;

        // Act
        taskController.deleteTask(taskId);

        // Assert
        verify(taskService, times(1)).deleteTask(taskId);
    }
}
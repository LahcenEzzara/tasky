package com.lahcencodes.tasky.services;

import com.lahcencodes.tasky.entities.Task;
import com.lahcencodes.tasky.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test class for TaskServiceImpl.
 * This class contains unit tests for the TaskServiceImpl methods.
 */
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the getAllTasks method.
     */
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

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // Act
        List<Task> tasks = taskService.getAllTasks();

        // Assert
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    /**
     * Tests the createTask method.
     */
    @Test
    void testCreateTask() {
        // Arrange
        Task task = new Task();
        task.setId(1);
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setUserId(1);

        when(taskRepository.save(task)).thenReturn(task);

        // Act
        taskService.createTask(task);

        // Assert
        verify(taskRepository, times(1)).save(task);
    }

    /**
     * Tests the updateTask method.
     */
    @Test
    void testUpdateTask() {
        // Arrange
        Task task = new Task();
        task.setId(1);
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setUserId(1);

        when(taskRepository.save(task)).thenReturn(task);

        // Act
        taskService.updateTask(task);

        // Assert
        verify(taskRepository, times(1)).save(task);
    }

    /**
     * Tests the deleteTask method.
     */
    @Test
    void testDeleteTask() {
        // Arrange
        int taskId = 1;

        // Act
        taskService.deleteTask(taskId);

        // Assert
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
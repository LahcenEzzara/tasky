package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.entities.Task;
import com.lahcencodes.tasky.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling task-related HTTP requests.
 * This class provides REST endpoints for managing tasks.
 */
@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Retrieves all tasks.
     *
     * @return a list of all tasks.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Creates a new task.
     *
     * @param task the task to be created.
     */
    @PostMapping
    public void createTask(@RequestBody Task task) {
        log.info("Creating task: {} with description: {}", task.getTitle(), task.getDescription());
        taskService.createTask(task);
    }

    /**
     * Updates an existing task.
     *
     * @param id   the ID of the task to be updated.
     * @param task the updated task data.
     */
    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task) {
        task.setId(id);
        taskService.updateTask(task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id the ID of the task to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.entities.Task;
import com.lahcencodes.tasky.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        log.info("Creating task: {} with description: {}", task.getTitle(), task.getDescription());
        taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task) {
        task.setId(id);
        taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
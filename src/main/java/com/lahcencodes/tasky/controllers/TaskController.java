package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.dao.TaskDao;
import com.lahcencodes.tasky.entities.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskDao taskDao = new TaskDao();

    @GetMapping
    public List<Task> getAllTasks() {
        List<Task> tasks = taskDao.getAllTasks();
        for (Task task : tasks) {
            if (task.title == null) {
                task.title = "No Title";
            }
            if (task.description == null) {
                task.description = "No Description";
            }
        }
        return tasks;
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        System.out.println("Creating task: " + task.title + " with description: " + task.description);
        taskDao.createTask(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task task) {
        task.id = id;
        taskDao.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskDao.deleteTask(id);
    }

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password123";

    @PostMapping("/admin")
    public void adminAction(@RequestParam String username, @RequestParam String password) {
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Admin action performed!");
        } else {
            System.out.println("Access denied!");
        }
    }
}
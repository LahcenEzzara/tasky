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
        return taskDao.getAllTasks();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
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
}

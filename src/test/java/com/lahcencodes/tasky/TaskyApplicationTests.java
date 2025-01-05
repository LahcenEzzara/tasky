package com.lahcencodes.tasky;

import com.lahcencodes.tasky.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskyApplicationTests {

    @Autowired
    private TaskService taskService;

    @Test
    void contextLoads() {
        assertNotNull(taskService);
    }

    @Test
    void testGetAllTasks() {
        assertNotNull(taskService.getAllTasks());
    }
}
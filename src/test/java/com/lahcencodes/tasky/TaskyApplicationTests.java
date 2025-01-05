package com.lahcencodes.tasky;

import com.lahcencodes.tasky.controllers.TaskController;
import com.lahcencodes.tasky.controllers.UserController;
import com.lahcencodes.tasky.services.TaskService;
import com.lahcencodes.tasky.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TaskyApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskController taskController;

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        // Verify that the application context loads successfully
        assertNotNull(applicationContext);
    }

    @Test
    void testTaskServiceBean() {
        // Verify that the TaskService bean is initialized
        assertNotNull(taskService);
    }

    @Test
    void testUserServiceBean() {
        // Verify that the UserService bean is initialized
        assertNotNull(userService);
    }

    @Test
    void testTaskControllerBean() {
        // Verify that the TaskController bean is initialized
        assertNotNull(taskController);
    }

    @Test
    void testUserControllerBean() {
        // Verify that the UserController bean is initialized
        assertNotNull(userController);
    }
}
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

/**
 * Test class for the TaskyApplication.
 * This class contains tests to verify that the application context loads successfully
 * and that the required beans are initialized.
 */
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

    /**
     * Tests that the application context loads successfully.
     */
    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
    }

    /**
     * Tests that the TaskService bean is initialized.
     */
    @Test
    void testTaskServiceBean() {
        assertNotNull(taskService);
    }

    /**
     * Tests that the UserService bean is initialized.
     */
    @Test
    void testUserServiceBean() {
        assertNotNull(userService);
    }

    /**
     * Tests that the TaskController bean is initialized.
     */
    @Test
    void testTaskControllerBean() {
        assertNotNull(taskController);
    }

    /**
     * Tests that the UserController bean is initialized.
     */
    @Test
    void testUserControllerBean() {
        assertNotNull(userController);
    }
}
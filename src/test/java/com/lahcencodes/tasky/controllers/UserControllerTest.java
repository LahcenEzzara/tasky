package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.entities.User;
import com.lahcencodes.tasky.services.UserService;
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
 * Test class for UserController.
 * This class contains unit tests for the UserController methods.
 */
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the getAllUsers method.
     */
    @Test
    void testGetAllUsers() {
        // Arrange
        User user1 = new User();
        user1.setId(1);
        user1.setName("User 1");
        user1.setEmail("user1@example.com");

        User user2 = new User();
        user2.setId(2);
        user2.setName("User 2");
        user2.setEmail("user2@example.com");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // Act
        List<User> users = userController.getAllUsers();

        // Assert
        assertEquals(2, users.size());
        verify(userService, times(1)).getAllUsers();
    }

    /**
     * Tests the createUser method.
     */
    @Test
    void testCreateUser() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@example.com");

        // Act
        userController.createUser(user);

        // Assert
        verify(userService, times(1)).createUser(user);
    }

    /**
     * Tests the updateUser method.
     */
    @Test
    void testUpdateUser() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@example.com");

        // Act
        userController.updateUser(1, user);

        // Assert
        verify(userService, times(1)).updateUser(user);
    }

    /**
     * Tests the deleteUser method.
     */
    @Test
    void testDeleteUser() {
        // Arrange
        int userId = 1;

        // Act
        userController.deleteUser(userId);

        // Assert
        verify(userService, times(1)).deleteUser(userId);
    }

    /**
     * Tests the getUserEmail method.
     */
    @Test
    void testGetUserEmail() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@example.com");

        when(userService.getUserEmail(1)).thenReturn("user1@example.com");

        // Act
        String email = userController.getUserEmail(1);

        // Assert
        assertEquals("user1@example.com", email);
        verify(userService, times(1)).getUserEmail(1);
    }
}
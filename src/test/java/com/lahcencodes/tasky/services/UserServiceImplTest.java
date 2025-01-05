package com.lahcencodes.tasky.services;

import com.lahcencodes.tasky.entities.User;
import com.lahcencodes.tasky.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Act
        List<User> users = userService.getAllUsers();

        // Assert
        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testCreateUser() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@example.com");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        userService.createUser(user);

        // Assert
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testUpdateUser() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@example.com");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        userService.updateUser(user);

        // Assert
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        int userId = 1;

        // Act
        userService.deleteUser(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testGetUserEmail() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("User 1");
        user.setEmail("user1@example.com");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        // Act
        String email = userService.getUserEmail(1);

        // Assert
        assertEquals("user1@example.com", email);
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testGetUserEmail_UserNotFound() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        // Act
        String email = userService.getUserEmail(1);

        // Assert
        assertNull(email);
        verify(userRepository, times(1)).findById(1);
    }
}
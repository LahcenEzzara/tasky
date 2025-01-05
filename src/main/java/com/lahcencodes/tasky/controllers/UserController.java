package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.entities.User;
import com.lahcencodes.tasky.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling user-related HTTP requests.
 * This class provides REST endpoints for managing users.
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Creates a new user.
     *
     * @param user the user to be created.
     */
    @PostMapping
    public void createUser(@RequestBody User user) {
        log.info("Creating user: {}", user.getName());
        userService.createUser(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id   the ID of the user to be updated.
     * @param user the updated user data.
     */
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id the ID of the user to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    /**
     * Retrieves the email of a user by their ID.
     *
     * @param id the ID of the user.
     * @return the email of the user.
     */
    @GetMapping("/{id}/email")
    public String getUserEmail(@PathVariable int id) {
        return userService.getUserEmail(id);
    }
}
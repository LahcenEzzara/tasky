package com.lahcencodes.tasky.controllers;

import com.lahcencodes.tasky.dao.UserDao;
import com.lahcencodes.tasky.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserDao userDao = new UserDao();

    @GetMapping
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userDao.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        user.id = id;
        userDao.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userDao.deleteUser(id);
    }
}

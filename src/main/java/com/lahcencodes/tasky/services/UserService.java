package com.lahcencodes.tasky.services;

import com.lahcencodes.tasky.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    String getUserEmail(int id);
}
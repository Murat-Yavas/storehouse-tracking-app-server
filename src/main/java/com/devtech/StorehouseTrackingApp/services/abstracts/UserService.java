package com.devtech.StorehouseTrackingApp.services.abstracts;

import com.devtech.StorehouseTrackingApp.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveOneUser(User newUser);

    User getOneUserById(Long userId);
    User getOneUserByUserName(String userName);

    User updateOneUser(Long userId, User newUser);

    void deleteById(Long userId);
}

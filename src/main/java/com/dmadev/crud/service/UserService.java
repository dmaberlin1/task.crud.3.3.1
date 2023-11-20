package com.dmadev.crud.service;

import com.dmadev.crud.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User deleteUser(int parseInt);

    void createOrUpdateUser(User user);
}

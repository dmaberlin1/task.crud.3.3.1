package com.dmadev.crud.repository;
import com.dmadev.crud.model.User;


import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User deleteUser(int id);
}

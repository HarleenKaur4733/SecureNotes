package com.harleen.secure_notes.service;

import java.util.List;

import com.harleen.secure_notes.entity.User;

public interface UserService {
    User registerUser(User user);

    List<User> getAllUsers();

}

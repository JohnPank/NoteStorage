package com.johnpank.notestorage.service;

import com.johnpank.notestorage.models.User;

public interface UserService {
    int createUser(User user);
    User getUserById(long id);
    User getUserByLogin(String login);
    int updateUser(User user);
    int deleteUser(User user);
}

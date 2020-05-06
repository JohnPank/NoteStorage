package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.models.User;

import javax.sql.DataSource;

public interface UserDAO {
    int createUser(User user);
    User getUserById(long id);
    User getUserByLogin(String login);
    int updateUser(User user);
    int deleteUser(User user);
}

package com.johnpank.notestorage.service;

import com.johnpank.notestorage.dao.NoteDAO;
import com.johnpank.notestorage.dao.UserDAO;
import com.johnpank.notestorage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    final
    UserDAO userDao;

    final
    NoteDAO noteDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao, NoteDAO noteDao) {
        this.userDao = userDao;
        this.noteDao = noteDao;
    }

    @Override
    public int createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User getUserById(long id) {
        User user =  userDao.getUserById(id);
        user.setNotes(noteDao.getNotesByUserId(id));
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = userDao.getUserByLogin(login);
        user.setNotes(noteDao.getNotesByUserId(user.getUser_id()));
        return user;
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        noteDao.deleteAllNoteByUserId(user.getUser_id());
        return userDao.deleteUser(user);
    }
}

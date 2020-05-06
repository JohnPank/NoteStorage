package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.config.TestAppConfig;
import com.johnpank.notestorage.models.Note;
import com.johnpank.notestorage.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestAppConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserDAOImplTest {


    @Autowired
    private UserDAO testUserDao;

//    @Before
//    public void setUp(DataSource dataSource) throws Exception {
//        userDao = new UserDAOImpl(dataSource);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        userDao = null;
//    }

    @Test
    public void createUser() {
        User user = new User();
        user.setUser_id(1);
        user.setLogin("logiiin");
        user.setPassword("passsssssword");
        user.setEmail("eeeeeeemaillll");
        user.setReg_date(new Date());
        user.setNotes(new ArrayList<Note>());
        int result = testUserDao.createUser(user);
        assertEquals(1,result);
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void getUserByLogin() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}
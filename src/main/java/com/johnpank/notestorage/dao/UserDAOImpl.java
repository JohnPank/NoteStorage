package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.config.DBContract;
import com.johnpank.notestorage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("userDao")
public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createUser(User user) {
        String SQL = "INSERT INTO " + DBContract.TABLE_USER_NAME + " (" + DBContract.USER_LOGIN_COLUMN + ", " + DBContract.USER_PASSWORD_COLUMN + ", " + DBContract.USER_EMAIL_COLUMN + ", " + DBContract.USER_REG_DATE_COLUMN + ") VALUES (?,?,?,?)";
        int temp = jdbcTemplate.update(SQL, user.getLogin(), user.getPassword(), user.getEmail(), user.getReg_date());
        return temp;
    }

    @Override
    public User getUserById(long id) {
        String SQL = "SELECT * FROM " + DBContract.TABLE_USER_NAME + " WHERE " + DBContract.USER_ID_COLUMN + " = ?";
        User user = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new UserRowMapper());
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        String SQL = "SELECT * FROM " + DBContract.TABLE_USER_NAME + " WHERE " + DBContract.USER_LOGIN_COLUMN + " = ?";
        User user = jdbcTemplate.queryForObject(SQL, new Object[]{login}, new UserRowMapper());
        return user;
    }

    @Override
    public int updateUser(User user) {
        String SQL = "UPDATE " + DBContract.TABLE_USER_NAME + " SET "
                + DBContract.USER_LOGIN_COLUMN + " = ?, "
                + DBContract.USER_PASSWORD_COLUMN + " = ?, "
                + DBContract.USER_EMAIL_COLUMN + " = ?, "
                + DBContract.USER_REG_DATE_COLUMN + " = ?"
                + " WHERE " + DBContract.USER_ID_COLUMN + " = ?";
        int temp = jdbcTemplate.update(SQL, user.getLogin(), user.getPassword(), user.getEmail(), user.getReg_date(), user.getUser_id());
        return temp;
    }

    @Override
    public int deleteUser(User user) {
        String SQL = "DELETE FROM " + DBContract.TABLE_USER_NAME + " WHERE " + DBContract.USER_ID_COLUMN + " = ?";
        int temp =jdbcTemplate.update(SQL, user.getUser_id());
        return temp;
    }
}

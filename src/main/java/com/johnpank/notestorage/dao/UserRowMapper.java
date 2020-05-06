package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.config.DBContract;
import com.johnpank.notestorage.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getLong(DBContract.USER_ID_COLUMN));
        user.setLogin(rs.getString(DBContract.USER_LOGIN_COLUMN));
        user.setPassword(rs.getString(DBContract.USER_PASSWORD_COLUMN));
        user.setEmail(rs.getString(DBContract.USER_EMAIL_COLUMN));
        user.setReg_date(rs.getTimestamp(DBContract.USER_REG_DATE_COLUMN));
        return user;
    }
}

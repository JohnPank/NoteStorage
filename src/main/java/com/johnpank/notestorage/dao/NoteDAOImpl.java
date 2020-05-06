package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.config.DBContract;
import com.johnpank.notestorage.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("noteDao")
public class NoteDAOImpl implements NoteDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NoteDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int createNote(Note note) {
        String SQL = "INSERT INTO " + DBContract.TABLE_NOTE_NAME + " (" + DBContract.NOTE_USER_ID_COLUMN + ", " + DBContract.NOTE_CONTENT_COLUMN + ", " + DBContract.NOTE_CREATION_DATE_COLUMN + ", " + DBContract.NOTE_IDENT_ICON_COLUMN + ") VALUES (?,?,?,?)";
        int temp = jdbcTemplate.update(SQL, note.getUser_id(), note.getContent(), note.getCreation_date(), note.getIdent_icon());
        return temp;
    }

    @Override
    public Note getNoteById(long id) {
        String SQL = "SELECT * FROM " + DBContract.TABLE_NOTE_NAME + " WHERE " + DBContract.NOTE_ID_COLUMN + " = ?";
        Note note= jdbcTemplate.queryForObject(SQL, new Object[]{id}, new NoteRowMapper());
        return note;
    }

    @Override
    public List<Note> getNotesByUserId(Long userId) {
        String SQL = "SELECT * FROM " + DBContract.TABLE_NOTE_NAME + " WHERE " + DBContract.NOTE_USER_ID_COLUMN + " = ?";
        List<Note> notes = new ArrayList<>();
        notes= jdbcTemplate.query(SQL,new Object[]{userId}, new NoteRowMapper());
        return notes;
    }

    @Override
    public int updateNote(Note note) {
        String SQL = "UPDATE " + DBContract.TABLE_NOTE_NAME + " SET "
                + DBContract.NOTE_USER_ID_COLUMN + " = ?, "
                + DBContract.NOTE_CONTENT_COLUMN + " = ?, "
                + DBContract.NOTE_EDIT_DATE_COLUMN + " = ?" +
                " WHERE " + DBContract.NOTE_ID_COLUMN + " = ?";
        int temp = jdbcTemplate.update(SQL, note.getUser_id(), note.getContent(), new Date(), note.getNote_id());
        return temp;
    }

    @Override
    public int deleteNote(Note note) {
        String SQL = "DELETE FROM " + DBContract.TABLE_NOTE_NAME + " WHERE " + DBContract.NOTE_ID_COLUMN + " = ?";
        int temp = jdbcTemplate.update(SQL, note.getNote_id());
        return temp;
    }

    @Override
    public int deleteAllNoteByUserId(long userId) {
        String SQL = "DELETE FROM " + DBContract.TABLE_NOTE_NAME + " WHERE " + DBContract.NOTE_USER_ID_COLUMN + " = ?";
        int temp = jdbcTemplate.update(SQL, userId);
        return temp;
    }
}

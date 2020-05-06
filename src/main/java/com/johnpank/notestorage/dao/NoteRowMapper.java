package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.config.DBContract;
import com.johnpank.notestorage.models.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteRowMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        Note note = new Note();
        note.setNote_id(rs.getLong(DBContract.NOTE_ID_COLUMN));
        note.setUser_id(rs.getLong(DBContract.NOTE_USER_ID_COLUMN));
        note.setContent(rs.getString(DBContract.NOTE_CONTENT_COLUMN));
        note.setCreation_date(rs.getTimestamp(DBContract.NOTE_CREATION_DATE_COLUMN));
        note.setEdit_date(rs.getTimestamp(DBContract.NOTE_EDIT_DATE_COLUMN));
        note.setIdent_icon(rs.getBytes(DBContract.NOTE_IDENT_ICON_COLUMN));
        return note;
    }
}

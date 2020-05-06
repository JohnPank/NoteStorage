package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.models.Note;

import javax.sql.DataSource;
import java.util.List;

public interface NoteDAO {
    int createNote(Note note);
    Note getNoteById(long id);
    List<Note> getNotesByUserId(Long userId);
    int updateNote(Note note);
    int deleteNote(Note note);
    int deleteAllNoteByUserId(long userId);
}

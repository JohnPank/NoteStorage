package com.johnpank.notestorage.service;

import com.johnpank.notestorage.dao.NoteDAOImpl;
import com.johnpank.notestorage.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService{

    final
    NoteDAOImpl noteDAO;

    @Autowired
    public NoteServiceImpl(NoteDAOImpl noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    public int createNote(Note note) {
        return noteDAO.createNote(note);
    }

    @Override
    public Note getNoteById(long id) {
        return noteDAO.getNoteById(id);
    }

    @Override
    public List<Note> getNotesByUserId(Long userId) {
        return noteDAO.getNotesByUserId(userId);
    }

    @Override
    public int updateNote(Note note) {
        return noteDAO.updateNote(note);
    }

    @Override
    public int deleteNote(Note note) {
        return noteDAO.deleteNote(note);
    }

    @Override
    public int deleteAllNoteByUserId(long userId) {
        return noteDAO.deleteAllNoteByUserId(userId);
    }
}

package com.johnpank.notestorage.service;

import com.johnpank.notestorage.models.Note;

import java.util.List;

public interface NoteService {
    int createNote(Note note);
    Note getNoteById(long id);
    List<Note> getNotesByUserId(Long userId);
    int updateNote(Note note);
    int deleteNote(Note note);
    int deleteAllNoteByUserId(long userId);
}

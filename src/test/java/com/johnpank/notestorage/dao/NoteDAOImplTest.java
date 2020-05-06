package com.johnpank.notestorage.dao;

import com.johnpank.notestorage.config.TestAppConfig;
import com.johnpank.notestorage.models.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppConfig.class, loader = AnnotationConfigContextLoader.class)
public class NoteDAOImplTest {

    @Autowired
    NoteDAOImpl testNoteDao;


    @Test
    public void createNote() {
        Note note = new Note();
        note.setNote_id(1);
        note.setUser_id(2);
        note.setContent("test content");
        note.setCreation_date(new Date());
        note.setIdent_icon(new byte[]{1, 2, 2, 1});
        note.setEdit_date(new Date());

        int result = testNoteDao.createNote(note);
        assertEquals(1, result);
    }

    @Test
    public void getNoteById() {
    }

    @Test
    public void getNotesByUserId() {
    }

    @Test
    public void updateNote() {
    }

    @Test
    public void deleteNote() {
    }

    @Test
    public void deleteAllNoteByUserId() {
    }
}
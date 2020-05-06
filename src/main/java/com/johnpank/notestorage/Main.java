package com.johnpank.notestorage;

import com.johnpank.notestorage.config.AppConfig;
import com.johnpank.notestorage.dao.NoteDAO;
import com.johnpank.notestorage.dao.UserDAOImpl;
import com.johnpank.notestorage.models.Note;
import com.johnpank.notestorage.models.User;
import com.johnpank.notestorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start application");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



        context.close();
        System.out.println("Application terminated");
    }
}

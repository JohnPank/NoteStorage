package com.johnpank.notestorage.config;

import com.johnpank.notestorage.dao.NoteDAO;
import com.johnpank.notestorage.dao.NoteDAOImpl;
import com.johnpank.notestorage.dao.UserDAO;
import com.johnpank.notestorage.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("com.johnpank.notestorage")
@PropertySource("classpath:appProperties.properties")
public class TestAppConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource testDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("test.db.driver")));
        dataSource.setUrl(env.getProperty("test.db.url"));
        dataSource.setUsername(env.getProperty("test.db.userName"));
        dataSource.setPassword(env.getProperty("test.db.password"));
        return dataSource;
    }

    @Bean
    UserDAO testUserDao(){
        return new UserDAOImpl(testDataSource());
    }

    @Bean
    NoteDAO testNoteDao(){
        return new NoteDAOImpl(testDataSource());
    }
}

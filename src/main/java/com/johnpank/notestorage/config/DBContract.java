package com.johnpank.notestorage.config;

public class DBContract {

    public static final String DB_NAME = "note_storage_db";

    //users
    public static final String TABLE_USER_NAME = "users";
    public static final String USER_ID_COLUMN = "id";
    public static final String USER_LOGIN_COLUMN = "login";
    public static final String USER_PASSWORD_COLUMN = "password";
    public static final String USER_EMAIL_COLUMN = "email";
    public static final String USER_REG_DATE_COLUMN = "reg_date";

    //notes
    public static final String TABLE_NOTE_NAME = "notes";
    public static final String NOTE_ID_COLUMN = "id";
    public static final String NOTE_USER_ID_COLUMN = "user_id";
    public static final String NOTE_CONTENT_COLUMN = "content";
    public static final String NOTE_CREATION_DATE_COLUMN = "creation_date";
    public static final String NOTE_EDIT_DATE_COLUMN = "edit_date";
    public static final String NOTE_IDENT_ICON_COLUMN = "ident_icon";
}

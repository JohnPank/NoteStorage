package com.johnpank.notestorage.models;


import java.util.Arrays;
import java.util.Date;

public class Note {
    private long note_id;
    private long user_id;
    private String content;
    private Date creation_date;
    private Date edit_date;
    private byte[] ident_icon;

    public long getNote_id() {
        return note_id;
    }

    public void setNote_id(long note_id) {
        this.note_id = note_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(Date edit_date) {
        this.edit_date = edit_date;
    }

    public byte[] getIdent_icon() {
        return ident_icon;
    }

    public void setIdent_icon(byte[] ident_icon) {
        this.ident_icon = ident_icon;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", creation_date=" + creation_date +
                ", edit_date=" + edit_date +
                ", ident_icon=" + Arrays.toString(ident_icon) +
                '}';
    }
}

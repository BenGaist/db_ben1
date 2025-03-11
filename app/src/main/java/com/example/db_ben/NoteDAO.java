package com.example.db_ben;

import android.provider.ContactsContract;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public interface NoteDAO {
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);
    @Query("SELECT * FROM notes WHERE id = :id")
    Note getNoteByID(int id);
}

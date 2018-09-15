package com.flycar.asmagannouni.compfeflycar.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.flycar.asmagannouni.compfeflycar.Utilities.DaoAccess;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess() ;
}
package com.shubhral.myfirstmvvp.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Shubhral on 3/28/2018.
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static final Object LOCK = new Object();
    private static WordRoomDatabase instance;

    static WordRoomDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                            WordRoomDatabase.class,
                            "word_db").build();
                }
            }
        }
        return instance;
    }
}

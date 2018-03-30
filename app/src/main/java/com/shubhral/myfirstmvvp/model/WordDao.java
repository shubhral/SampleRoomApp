package com.shubhral.myfirstmvvp.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Shubhral on 3/28/2018.
 */
@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("SELECT * from word_table ORDER BY id DESC")
    LiveData<List<Word>> getAllWords();

    @Update()
    void updateWord(Word word);

}

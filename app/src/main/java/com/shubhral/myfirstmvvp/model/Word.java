package com.shubhral.myfirstmvvp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Shubhral on 3/28/2018.
 */

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String word;

    //constructor used by us, hence needs to be annotated with ignore so that room ignores it
    @Ignore
    public Word(@NonNull String word) {
        this.word = word;
    }

    //constructor used by Room
    Word(int id, @NonNull String word) {
        this.id = id;
        this.word = word;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public int getId() {
        return id;
    }

}

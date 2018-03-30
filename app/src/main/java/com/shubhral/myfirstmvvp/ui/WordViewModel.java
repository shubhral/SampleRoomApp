package com.shubhral.myfirstmvvp.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.shubhral.myfirstmvvp.model.Word;
import com.shubhral.myfirstmvvp.model.WordRepository;

import java.util.List;

/**
 * Created by Shubhral on 3/29/2018.
 */

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>> allWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        allWords = wordRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    void insertWord(String entry) {
        wordRepository.insertWord(entry);
    }

}

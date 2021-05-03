package com.example.diplomandroid.ui.journals.calories;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class CaloriesJournalViewModel extends AndroidViewModel {
    private final AppRepository repository;

    public CaloriesJournalViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void saveCalories(Context context, Integer weight, String date) {
        repository.saveCalories(context, weight, date);
    }

    public void getCalories(Context context, String date) {
        repository.getCalories(context, date);
    }
}

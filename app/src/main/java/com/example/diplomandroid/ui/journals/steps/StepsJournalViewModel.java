package com.example.diplomandroid.ui.journals.steps;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class StepsJournalViewModel extends AndroidViewModel {

    private final AppRepository repository;

    public StepsJournalViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void saveSteps(Context context, Integer stepsAmount, String date) {
        repository.saveSteps(context, stepsAmount, date);
    }

    public void getSteps(Context context, String date) {
        repository.getSteps(context, date);
    }
}

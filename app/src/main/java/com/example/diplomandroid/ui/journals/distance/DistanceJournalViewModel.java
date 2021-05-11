package com.example.diplomandroid.ui.journals.distance;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class DistanceJournalViewModel extends AndroidViewModel {
    private final AppRepository repository;

    public DistanceJournalViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void saveDistance(Context context, Integer weight, String date) {
        repository.saveDistance(context, weight, date);
    }

    public void getDistance(Context context, String date) {
        repository.getDistance(context, date);
    }
}

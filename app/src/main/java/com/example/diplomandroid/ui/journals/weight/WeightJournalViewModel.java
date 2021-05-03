package com.example.diplomandroid.ui.journals.weight;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class WeightJournalViewModel extends AndroidViewModel {

    private final AppRepository repository;

    public WeightJournalViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void saveWeight(Context context, Integer weight, String date) {
        repository.saveWeight(context, weight, date);
    }

    public void getWeight(Context context, String date) {
        repository.getWeight(context, date);
    }
}

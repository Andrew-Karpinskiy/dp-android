package com.example.diplomandroid.ui.calculators.iw;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class IdealWeightViewModel extends AndroidViewModel {

    private final AppRepository repository;

    public IdealWeightViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void getIdealWeight(Context context, TextView result, String gender, EditText heightEditText) {
        repository.getIdealWeight(context, result, gender, Double.parseDouble(String.valueOf(heightEditText.getText())));
    }

    public String validateIwInput(Context context, String gender, EditText heightEditText) {
        return repository.validateIwInput(context, gender, heightEditText);
    }
}

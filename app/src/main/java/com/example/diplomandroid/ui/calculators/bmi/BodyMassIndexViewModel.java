package com.example.diplomandroid.ui.calculators.bmi;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class BodyMassIndexViewModel extends AndroidViewModel {

    private final AppRepository repository;

    public BodyMassIndexViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void calculateBodyMassIndex(Context context, TextView result, EditText weightEditText, EditText heightEditText) {
        double weight = Double.parseDouble(String.valueOf(weightEditText.getText()));
        double height = Double.parseDouble(String.valueOf(heightEditText.getText()));
        repository.calculateBodyMassIndex(context, result, weight, height);
    }

    public String validateBmiInput(Context context, EditText weightEditText, EditText heightEditText) {
        return repository.validateBmiInput(context, weightEditText, heightEditText);
    }
}

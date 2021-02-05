package com.example.diplomandroid.ui.calculators.dca;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class DailyCaloriesAmountViewModel extends AndroidViewModel {
    private final AppRepository repository;

    public DailyCaloriesAmountViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void getDailyCaloriesAmount(Context context, TextView result, String gender,
                                       EditText weight, EditText height, EditText age, String loadFactor) {
        repository.getDailyCaloriesAmount(context, result, gender, Double.parseDouble(String.valueOf(weight.getText())),
                Double.parseDouble(String.valueOf(height.getText())), Double.parseDouble(String.valueOf(age.getText())), loadFactor);
    }

    public String validateInput(Context context, String gender, EditText weightEditText, EditText heightEditText,
                                EditText ageEditText) {

        return repository.validateDcaInput(context, gender, weightEditText, heightEditText, ageEditText);
    }
}

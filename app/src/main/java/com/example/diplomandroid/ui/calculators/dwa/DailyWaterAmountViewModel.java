package com.example.diplomandroid.ui.calculators.dwa;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.repository.AppRepository;

public class DailyWaterAmountViewModel extends AndroidViewModel {

    private final AppRepository repository;

    public DailyWaterAmountViewModel(@NonNull Application application) {
        super(application);
        repository = AppRepository.getInstance();
    }

    public void getDailyWaterAmount(Context context, TextView result, EditText weightEditText) {
        repository.getDailyWaterAmount(context, result, Double.parseDouble(String.valueOf(weightEditText.getText())));
    }

    public String validateDwaInputData(Context context, EditText weightEditText) {
        return repository.validateDwaInput(context, weightEditText);
    }
}

package com.example.diplomandroid.repository;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.example.diplomandroid.repository.retrofit.RetrofitController;


public class AppRepository {
    private static AppRepository instance;
    private final RetrofitController retrofit;
    private final InputDataValidation inputDataValidation;

    private AppRepository() {
        retrofit = new RetrofitController();
        inputDataValidation = new InputDataValidation();
    }

    public static AppRepository getInstance() {
        if (instance == null) {
            instance = new AppRepository();
        }
        return instance;
    }

    public void calculateBodyMassIndex(Context context, TextView result, double weight, double height) {
        retrofit.getBodyMassIndex(context, result, weight, height);
    }

    public String validateBmiInput(Context context, EditText weightEditText, EditText heightEditText) {
        return inputDataValidation.validateBmiInput(context, weightEditText, heightEditText);
    }

    public void getDailyWaterAmount(Context context, TextView result, double weight) {
        retrofit.getDailyWaterAmount(context, result, weight);
    }

    public String validateDwaInput(Context context, EditText weightEditText) {
        return inputDataValidation.validateDwaInput(context, weightEditText);
    }

    public void getIdealWeight(Context context, TextView result, String gender, double height) {
        retrofit.getIdealWeight(context, result, gender, height);
    }

    public String validateIwInput(Context context, String gender, EditText heightEditText) {
        return inputDataValidation.validateIwInput(context, gender, heightEditText);
    }

    public void getDailyCaloriesAmount(Context context, TextView result, String gender, double weight, double height, double age,
                                       String loadFactor) {
        retrofit.getDailyCaloriesAmount(context, result, gender, weight, height, age, loadFactor);
    }

    public String validateDcaInput(Context context, String gender, EditText weightEditText, EditText heightEditText,
                                   EditText ageEditText) {

        return inputDataValidation.validateDcaInput(context, gender, weightEditText, heightEditText, ageEditText);
    }
}
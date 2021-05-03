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

    public void saveSteps(Context context, Integer stepsAmount, String date) {
        retrofit.saveStepsCall(context, stepsAmount, date);
    }

    public void saveDistance(Context context, Integer distanceAmount, String date) {
        retrofit.saveDistanceCall(context, distanceAmount, date);
    }

    public void saveCalories(Context context, Integer caloriesAmount, String date) {
        retrofit.saveCaloriesCall(context, caloriesAmount, date);
    }

    public void saveWeight(Context context, Integer weight, String date) {
        retrofit.saveWeightCall(context, weight, date);
    }

    public void getSteps(Context context, String date) {
        retrofit.getSteps(context, date);
    }

    public void getWeight(Context context, String date) {
        retrofit.getWeight(context, date);
    }

    public void getCalories(Context context, String date) {
        retrofit.getCalories(context, date);
    }

    public void getDistance(Context context, String date) {
        retrofit.getDistance(context, date);
    }
}
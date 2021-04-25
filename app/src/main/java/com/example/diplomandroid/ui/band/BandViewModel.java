package com.example.diplomandroid.ui.band;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.miband.DataReceiver;
import com.example.diplomandroid.miband.MiBandConnectionHelper;
import com.example.diplomandroid.repository.AppRepository;

public class BandViewModel extends AndroidViewModel {

    private final DataReceiver dataReceiver;
    private final MiBandConnectionHelper miBandConnectionHelper;
    private final AppRepository repository;

    public BandViewModel(@NonNull Application application) {
        super(application);
        dataReceiver = new DataReceiver();
        miBandConnectionHelper = new MiBandConnectionHelper();
        repository = AppRepository.getInstance();
    }

    public void connectToMiBand() {
        miBandConnectionHelper.connect();
    }

    public boolean getConnectStatus() {
        return dataReceiver.isConnectStatus();
    }

    public int getSteps() {
        return dataReceiver.getSteps();
    }

    public double getDistance() {
        return dataReceiver.getDistance();
    }

    public double getCalories() {
        return dataReceiver.getCalories();
    }

    public void saveSteps(Context context, Integer stepsAmount) {
        repository.saveSteps(context, stepsAmount);
    }

    public void saveDistance(Context context, Integer distanceAmount) {
        repository.saveDistance(context, distanceAmount);
    }

    public void saveCalories(Context context, Integer caloriesAmount) {
        repository.saveCalories(context, caloriesAmount);
    }

    public void saveWeight(Context context, Double weight) {
        repository.saveWeight(context, weight);
    }
}

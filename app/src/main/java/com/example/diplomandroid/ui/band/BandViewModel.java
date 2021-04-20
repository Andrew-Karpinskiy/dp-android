package com.example.diplomandroid.ui.band;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.miband.DataReceiver;
import com.example.diplomandroid.miband.MiBandConnectionHelper;

public class BandViewModel extends AndroidViewModel {

    private final DataReceiver dataReceiver;
    private final MiBandConnectionHelper miBandConnectionHelper;

    public BandViewModel(@NonNull Application application) {
        super(application);
        dataReceiver = new DataReceiver();
        miBandConnectionHelper = new MiBandConnectionHelper();
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
}

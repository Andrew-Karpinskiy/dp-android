package com.example.diplomandroid.ui.calculators;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public CalculatorsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calculators fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

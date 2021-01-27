package com.example.diplomandroid.ui.journals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JournalsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public JournalsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is journals fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

package com.example.diplomandroid.ui.journals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.R;

import java.util.ArrayList;
import java.util.List;

public class JournalsViewModel extends AndroidViewModel {
    public JournalsViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Journals> initData() {
        List<Journals> data = new ArrayList<>();
        data.add(new Journals(R.drawable.ic_wj, R.string.weight_journal_name, R.string.weight));
        data.add(new Journals(R.drawable.ic_dj, R.string.distance_journal_name, R.string.distance));
        data.add(new Journals(R.drawable.ic_sj, R.string.steps_journal_name, R.string.steps));
        data.add(new Journals(R.drawable.ic_cj, R.string.calories_journal_name, R.string.calories));
        return data;
    }
}

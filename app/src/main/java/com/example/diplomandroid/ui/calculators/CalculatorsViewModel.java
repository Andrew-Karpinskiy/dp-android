package com.example.diplomandroid.ui.calculators;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.diplomandroid.R;

import java.util.ArrayList;
import java.util.List;

public class CalculatorsViewModel extends AndroidViewModel {

    public CalculatorsViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Calculators> initData() {
        List<Calculators> data = new ArrayList<>();
        data.add(new Calculators(R.drawable.ic_bmi, R.string.bmi_calculator_name, R.string.bmi_calculator_description));
        data.add(new Calculators(R.drawable.ic_dwa, R.string.dwa_calculator_name, R.string.dwa_calculator_description));
        data.add(new Calculators(R.drawable.ic_dca, R.string.dca_calculator_name, R.string.dca_calculator_description));
        data.add(new Calculators(R.drawable.ic_iw, R.string.iw_calculator_name, R.string.iw_calculator_description));
        return data;
    }
}

package com.example.diplomandroid.ui.calculators.dwa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;

public class DailyWaterAmountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_water_amount);
        getDailyWaterRequirement();
    }

    private void getDailyWaterRequirement() {
        final Button submitButton = findViewById(R.id.dwaSubmitButton);
        final EditText weightEditText = findViewById(R.id.dwaWeightEditText);
        final TextView result = findViewById(R.id.dwaResult);
        DailyWaterAmountViewModel dailyWaterAmountViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(DailyWaterAmountViewModel.class);
        submitButton.setOnClickListener((View v) -> {
            String validationResult = dailyWaterAmountViewModel.validateDwaInputData(this, weightEditText);
            if (validationResult.equals(getString(R.string.correct))) {
                dailyWaterAmountViewModel.getDailyWaterAmount(this, result, weightEditText);
            } else {
                Toast.makeText(this, validationResult, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.diplomandroid.ui.calculators.dca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;

public class DailyCaloriesAmountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calories_amount);
        getDailyCaloriesAmount();
    }

    private void getDailyCaloriesAmount() {
        DailyCaloriesAmountViewModel dailyCaloriesAmountViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(DailyCaloriesAmountViewModel.class);

        final Button submitButton = findViewById(R.id.dcaSubmitButton);
        Spinner genderSpinner = findViewById(R.id.dcaGenderSpinner);
        final EditText weightEditText = findViewById(R.id.dcaWeightEditText);
        final EditText heightEditText = findViewById(R.id.dcaHeightEditText);
        final EditText ageEditText = findViewById(R.id.dcaAgeEditText);
        Spinner rateSpinner = findViewById(R.id.dcaRateSpinner);
        TextView result = findViewById(R.id.dcaResultLabel);

        submitButton.setOnClickListener((View v) -> {
            String selectedGender = genderSpinner.getSelectedItem().toString();
            String selectedRate = rateSpinner.getSelectedItem().toString();

            String validationResult = dailyCaloriesAmountViewModel.validateInput(this, selectedGender,
                    weightEditText, heightEditText, ageEditText);

            if (validationResult.equals(getString(R.string.correct))) {
                dailyCaloriesAmountViewModel.getDailyCaloriesAmount(this, result, selectedGender,
                        weightEditText, heightEditText, ageEditText, selectedRate);
            } else {
                Toast.makeText(this, validationResult, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
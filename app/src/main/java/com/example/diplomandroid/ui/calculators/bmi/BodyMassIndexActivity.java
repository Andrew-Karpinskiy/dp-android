package com.example.diplomandroid.ui.calculators.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;

public class BodyMassIndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index);
        calculateBodyMassIndex();
    }

    private void calculateBodyMassIndex() {
        BodyMassIndexViewModel bodyMassIndexViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(BodyMassIndexViewModel.class);
        final Button submitButton = findViewById(R.id.bmiSubmitButton);
        final EditText weightEditText = findViewById(R.id.bmiWeightEditText);
        final EditText heightEditText = findViewById(R.id.bmiHeightEditText);
        final TextView resultTextView = findViewById(R.id.bmiResult);
        submitButton.setOnClickListener((View v) -> {
            String validationResult = bodyMassIndexViewModel.validateBmiInput(this, weightEditText, heightEditText);
            if (validationResult.equals(getString(R.string.correct))) {
                bodyMassIndexViewModel.calculateBodyMassIndex(this, resultTextView, weightEditText, heightEditText);
            } else {
                Toast.makeText(this, validationResult, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
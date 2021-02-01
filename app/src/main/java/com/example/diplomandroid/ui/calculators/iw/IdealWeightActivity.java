package com.example.diplomandroid.ui.calculators.iw;

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

public class IdealWeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);
        getIdealWeight();
    }

    private void getIdealWeight() {
        final Button submitButton = findViewById(R.id.iwSubmitButton);
        final EditText heightEditText = findViewById(R.id.iwHeightEditText);
        TextView result = findViewById(R.id.iwResultLabel);
        Spinner genderSpinner = findViewById(R.id.iwSpinner);
        IdealWeightViewModel idealWeightViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(IdealWeightViewModel.class);
        submitButton.setOnClickListener((View v) -> {
            String selected = genderSpinner.getSelectedItem().toString();
            String validationResult = idealWeightViewModel.validateIwInput(this, selected, heightEditText);
            if (validationResult.equals(getString(R.string.correct))) {
                idealWeightViewModel.getIdealWeight(this, result, selected, heightEditText);
            } else {
                Toast.makeText(this, validationResult, Toast.LENGTH_SHORT).show();
            }

        });
    }
}
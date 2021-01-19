package com.example.diplomandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registration();
        login();
        bmi();
        dwr();
    }

    private void registration() {
        final Button button = findViewById(R.id.regButton);
        button.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void login() {
        final Button button = findViewById(R.id.logButton);
        button.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void bmi() {
        final Button button = findViewById(R.id.bmiButton);
        button.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, BodyMassIndexActivity.class);
            startActivity(intent);
        });
    }

    private void dwr() {
        final Button button = findViewById(R.id.dwrButton);
        button.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, DailyWaterRequirementActivity.class);
            startActivity(intent);
        });
    }
}
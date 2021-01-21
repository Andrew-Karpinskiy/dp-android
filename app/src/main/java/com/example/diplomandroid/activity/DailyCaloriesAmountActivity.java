package com.example.diplomandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.R;
import com.example.diplomandroid.retrofit.RetrofitController;

public class DailyCaloriesAmountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calories_amount);
        getDailyCaloriesAmount();
    }

    private void getDailyCaloriesAmount() {
        final Button button = findViewById(R.id.dailyCaloriesButton);
        final EditText sexEditText = findViewById(R.id.dailyCaloriesSexEditText);
        final EditText weightEditText = findViewById(R.id.dailyCaloriesWeightEditText);
        final EditText heightEditText = findViewById(R.id.dailyCaloriesHeightEditText);
        final EditText ageEditText = findViewById(R.id.dailyCaloriesAgeEditText);
        final EditText loadEditText = findViewById(R.id.dailyCaloriesLoadEditText);

        button.setOnClickListener((View v) -> {
            RetrofitController controller = new RetrofitController();
            controller.getDailyCaloriesAmount(this, sexEditText.getText().toString(),
                    Double.parseDouble(weightEditText.getText().toString()),
                    Double.parseDouble(heightEditText.getText().toString()),
                    Double.parseDouble(ageEditText.getText().toString()),
                    Integer.parseInt(loadEditText.getText().toString()));
        });
    }
}
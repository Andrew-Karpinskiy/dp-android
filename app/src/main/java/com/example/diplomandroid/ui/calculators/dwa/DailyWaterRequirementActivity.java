package com.example.diplomandroid.ui.calculators.dwa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.R;
import com.example.diplomandroid.repository.retrofit.RetrofitController;

public class DailyWaterRequirementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_water_requirement);
        getDailyWaterRequirement();
    }

    private void getDailyWaterRequirement() {
        final Button button = findViewById(R.id.dailyWaterButton);
        final EditText weightEditText = findViewById(R.id.dailyWaterWeightEditText);
        button.setOnClickListener((View v) -> {
            RetrofitController controller = new RetrofitController();
            controller.getDailyWaterRequirement(this,
                    Double.parseDouble(weightEditText.getText().toString()));
        });
    }
}
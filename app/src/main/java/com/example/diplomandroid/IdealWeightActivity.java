package com.example.diplomandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.retrofit.RetrofitController;

public class IdealWeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);
        getIdealWeight();
    }

    private void getIdealWeight() {
        final Button button = findViewById(R.id.idealWeightButton);
        final EditText heightEditText = findViewById(R.id.idelWeightHeightEditText);
        final EditText sexEditText = findViewById(R.id.idelWeightSexEditText);
        button.setOnClickListener((View v) -> {
            RetrofitController controller = new RetrofitController();
            controller.getIdealWeight(this, sexEditText.getText().toString(),
                    Double.parseDouble(heightEditText.getText().toString()));
        });
    }
}
package com.example.diplomandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.R;
import com.example.diplomandroid.retrofit.RetrofitController;

public class BodyMassIndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_mass_index);
        getBodyMassIndex();
    }

    private void getBodyMassIndex() {
        final Button button = findViewById(R.id.bodyMassIndexButton);
        final EditText weightEditText = findViewById(R.id.bodyMassIndexWeightEditText);
        final EditText heightEditText = findViewById(R.id.bodyMassIndexHeightEditText);
        button.setOnClickListener((View v) -> {
            RetrofitController controller = new RetrofitController();
            controller.getBodyMassIndex(this, Double.parseDouble(weightEditText.getText().toString()),
                    Double.parseDouble(heightEditText.getText().toString()));
        });
    }
}
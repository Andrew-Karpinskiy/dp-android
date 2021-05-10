package com.example.diplomandroid.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.R;
import com.example.diplomandroid.repository.retrofit.RetrofitController;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registration();
    }

    private void registration() {
        final Button button = findViewById(R.id.regButton);
        final EditText emailEditText = findViewById(R.id.regEmailEditText);
        final EditText passwordEditText = findViewById(R.id.regPasswordEditText);
        button.setOnClickListener((View v) -> {
            RetrofitController controller = new RetrofitController();
            controller.registration(this, emailEditText.getText().toString(),
                    passwordEditText.getText().toString());

        });
    }
}
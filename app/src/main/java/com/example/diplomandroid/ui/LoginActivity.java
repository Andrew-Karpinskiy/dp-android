package com.example.diplomandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.R;
import com.example.diplomandroid.repository.retrofit.RetrofitController;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }

    private void login() {
        final Button button = findViewById(R.id.LoginButton);
        final Button regButton = findViewById(R.id.logButton);
        final EditText emailEditText = findViewById(R.id.LoginEmailEditText);
        final EditText passwordEditText = findViewById(R.id.LoginPasswordEditText);
        button.setOnClickListener((View v) -> {
            RetrofitController controller = new RetrofitController();
            controller.login(this, emailEditText.getText().toString(),
                    passwordEditText.getText().toString());

        });
        regButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });
    }
}
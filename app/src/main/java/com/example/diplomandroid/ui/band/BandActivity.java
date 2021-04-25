package com.example.diplomandroid.ui.band;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;

import java.util.Arrays;


public class BandActivity extends AppCompatActivity {
    private BandViewModel bandViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band);
        getMiBandData();
        bandViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(BandViewModel.class);
    }

    @SuppressLint({"ResourceAsColor", "DefaultLocale", "SetTextI18n"})
    private void getMiBandData() {
        Button connectButton = findViewById(R.id.bandConnectButton);
        Button saveButton = findViewById(R.id.bandSaveButton);
        TextView connectStatus = findViewById(R.id.bandBluetoothStatusText);
        TextView distance = findViewById(R.id.bandDistanceText);
        TextView steps = findViewById(R.id.bandStepsText);
        TextView calories = findViewById(R.id.bandCaloriesText);
        EditText macAddress = findViewById(R.id.bandMacAddressEditText);
        connectButton.setOnClickListener((View v) -> {
            if (macAddress.getText() != null && macAddress.getText().length() > 0) {
                bandViewModel.connectToMiBand();
                connectStatus.setTextColor(ContextCompat.getColor(this, R.color.norm));
                connectStatus.setText(R.string.connected);
                distance.setText(String.format("%.0f", bandViewModel.getDistance()));
                steps.setText("" + bandViewModel.getSteps());
                calories.setText(String.format("%.0f", bandViewModel.getCalories()));
            } else {
                Toast.makeText(this, "Please input Mac address", Toast.LENGTH_SHORT).show();
            }
        });
        saveButton.setOnClickListener((View v) -> {
            showDialog();
        });

    }

    private void showDialog() {
        FragmentManager manager = getSupportFragmentManager();
        SaveDialog myDialogFragment = new SaveDialog();
        myDialogFragment.show(manager, "myDialog");
    }

    void saveData(boolean[] checkedItemsArray) {
        System.out.println(Arrays.toString(checkedItemsArray));
        if (checkedItemsArray[0]) {
            TextView distance = findViewById(R.id.bandDistanceText);
            int distanceAmount = Integer.parseInt(String.valueOf(distance.getText()));
            bandViewModel.saveDistance(this, distanceAmount);
        }
        if (checkedItemsArray[1]) {
            TextView steps = findViewById(R.id.bandStepsText);
            int stepsAmount = Integer.parseInt(String.valueOf(steps.getText()));
            bandViewModel.saveSteps(this, stepsAmount);
        }
        if (checkedItemsArray[2]) {
            TextView calories = findViewById(R.id.bandCaloriesText);
            int caloriesAmount = Integer.parseInt(String.valueOf(calories.getText()));
            bandViewModel.saveCalories(this, caloriesAmount);
        }
    }
}
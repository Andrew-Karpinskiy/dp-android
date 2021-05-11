package com.example.diplomandroid.repository;

import android.content.Context;
import android.widget.EditText;

import com.example.diplomandroid.R;

public class InputDataValidation {

    public String validateBmiInput(Context context, EditText weightEditText, EditText heightEditText) {
        if (weightEditText.getText().length() != 0 && heightEditText.getText().length() != 0) {
            return context.getString(R.string.correct);
        }
        if (weightEditText.getText().length() == 0 && heightEditText.getText().length() != 0) {
            return context.getString(R.string.empty_weight_form);
        } else if (heightEditText.getText().length() == 0 && weightEditText.getText().length() != 0) {
            return context.getString(R.string.empty_height_form);
        } else {
            return context.getString(R.string.all_forms_empty);
        }
    }

    public String validateDwaInput(Context context, EditText weightEditText) {
        if (weightEditText.getText().length() == 0) {
            return context.getString(R.string.empty_weight_form);
        } else {
            return context.getString(R.string.correct);
        }
    }

    public String validateIwInput(Context context, String gender, EditText heightEditText) {
        if (heightEditText.getText().length() != 0 && !gender.equals(context.getString(R.string.not_selected))) {
            return context.getString(R.string.correct);
        }
        if (heightEditText.getText().length() == 0 && !gender.equals(context.getString(R.string.not_selected))) {
            return context.getString(R.string.empty_height_form);
        } else if (heightEditText.getText().length() != 0 && gender.equals(context.getString(R.string.not_selected))) {
            return context.getString(R.string.empty_gender);
        } else {
            return context.getString(R.string.all_forms_empty);
        }
    }

    public String validateDcaInput(Context context, String gender, EditText weightEditText, EditText heightEditText,
                                   EditText ageEditText) {

        if (!gender.equals(context.getString(R.string.not_selected)) && weightEditText.getText().length() != 0
                && heightEditText.getText().length() != 0 && ageEditText.getText().length() != 0) {
            return context.getString(R.string.correct);
        }

        if (gender.equals(context.getString(R.string.not_selected)) && weightEditText.getText().length() != 0
                && heightEditText.getText().length() != 0 && ageEditText.getText().length() != 0) {
            return context.getString(R.string.empty_gender);
        } else if (!gender.equals(context.getString(R.string.not_selected)) && weightEditText.getText().length() == 0
                && heightEditText.getText().length() != 0 && ageEditText.getText().length() != 0) {
            return context.getString(R.string.empty_weight_form);
        } else if (!gender.equals(context.getString(R.string.not_selected)) && weightEditText.getText().length() != 0
                && heightEditText.getText().length() == 0 && ageEditText.getText().length() != 0) {
            return context.getString(R.string.empty_height_form);
        } else if (!gender.equals(context.getString(R.string.not_selected)) && weightEditText.getText().length() != 0
                && heightEditText.getText().length() != 0 && ageEditText.getText().length() == 0) {
            return context.getString(R.string.empty_age_form);
        } else if (gender.equals(context.getString(R.string.not_selected)) && weightEditText.getText().length() == 0
                && heightEditText.getText().length() == 0 && ageEditText.getText().length() == 0) {
            return context.getString(R.string.all_forms_empty);
        } else {
            return context.getString(R.string.not_all_forms_empty);
        }
    }
}

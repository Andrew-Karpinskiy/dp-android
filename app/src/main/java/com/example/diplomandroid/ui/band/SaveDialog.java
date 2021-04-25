package com.example.diplomandroid.ui.band;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import org.jetbrains.annotations.NotNull;

public class SaveDialog extends DialogFragment {
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {"Distance", "Steps", "Calories"};
        final boolean[] checkedItemsArray = {true, true, true};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose what to save")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        (dialog, which, isChecked) -> checkedItemsArray[which] = isChecked)
                .setPositiveButton("Save",
                        (dialog, id) -> {
                            ((BandActivity) getActivity()).saveData(checkedItemsArray);
                        })

                .setNegativeButton("Back",
                        (dialog, id) -> dialog.cancel());

        return builder.create();
    }
}

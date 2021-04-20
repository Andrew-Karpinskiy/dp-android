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
        final boolean[] checkedItemsArray = {false, true, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose what to save")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        (dialog, which, isChecked) -> checkedItemsArray[which] = isChecked)
                .setPositiveButton("Save",
                        (dialog, id) -> {
//                            StringBuilder state = new StringBuilder();
//                            for (int i = 0; i < catNamesArray.length; i++) {
//                                state.append(catNamesArray[i]);
//                                if (checkedItemsArray[i])
//                                    state.append(" выбран\n");
//                                else
//                                    state.append(" не выбран\n");
//                            }
//                            Toast.makeText(getActivity(),
//                                    state.toString(), Toast.LENGTH_LONG)
//                                    .show();
                            ((BandActivity) getActivity()).saveData();
                        })

                .setNegativeButton("Back",
                        (dialog, id) -> dialog.cancel());

        return builder.create();
    }
}

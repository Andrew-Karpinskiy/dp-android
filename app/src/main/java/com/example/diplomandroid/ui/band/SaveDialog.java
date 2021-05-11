package com.example.diplomandroid.ui.band;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.example.diplomandroid.R;

import org.jetbrains.annotations.NotNull;

public class SaveDialog extends DialogFragment {
    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] catNamesArray = {getString(R.string.distance), getString(R.string.steps), getString(R.string.calories_amount)};
        final boolean[] checkedItemsArray = {true, true, true};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.choose_what_save)
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        (dialog, which, isChecked) -> checkedItemsArray[which] = isChecked)
                .setPositiveButton(R.string.save,
                        (dialog, id) -> {
                            ((BandActivity) getActivity()).saveData(checkedItemsArray);
                        })

                .setNegativeButton(R.string.back,
                        (dialog, id) -> dialog.cancel());

        return builder.create();
    }
}

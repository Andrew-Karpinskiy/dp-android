package com.example.diplomandroid.ui.profile;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.diplomandroid.R;

public class ProfileFragment extends Fragment {
    private ProfileViewModel profileViewModel;

    @SuppressLint("ShowToast")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        Button button = root.findViewById(R.id.profChangeEmailButton);
        button.setOnClickListener(view -> {
            LayoutInflater li = LayoutInflater.from(root.getContext());
            View promptsView = li.inflate(R.layout.new_email_dialog, null);
            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(root.getContext());
            mDialogBuilder.setView(promptsView);
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok,
                            (dialog, id) -> {
                                Toast.makeText(root.getContext(), R.string.new_email_saved, Toast.LENGTH_SHORT);
                            })
                    .setNegativeButton(R.string.cancel,
                            (dialog, id) -> dialog.cancel());
            AlertDialog alertDialog = mDialogBuilder.create();
            alertDialog.show();
        });
        return root;
    }
}

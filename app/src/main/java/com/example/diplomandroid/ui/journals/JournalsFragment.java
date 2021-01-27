package com.example.diplomandroid.ui.journals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;

public class JournalsFragment extends Fragment {
    private JournalsViewModel journalsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        journalsViewModel =
                new ViewModelProvider(this).get(JournalsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_journals, container, false);
        final TextView textView = root.findViewById(R.id.text_journals);
        journalsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

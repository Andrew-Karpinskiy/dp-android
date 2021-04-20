package com.example.diplomandroid.ui.journals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomandroid.R;
import com.example.diplomandroid.ui.journals.adapter.JournalsRecyclerViewAdapter;

public class JournalsFragment extends Fragment {
    private JournalsViewModel journalsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        journalsViewModel =
                new ViewModelProvider(this).get(JournalsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_journals, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.journalsRecyclerView);
        JournalsRecyclerViewAdapter recyclerViewAdapter = new JournalsRecyclerViewAdapter(journalsViewModel.initData());

        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        return root;
    }
}

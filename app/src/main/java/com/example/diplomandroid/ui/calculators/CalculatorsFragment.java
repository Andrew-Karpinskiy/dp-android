package com.example.diplomandroid.ui.calculators;

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
import com.example.diplomandroid.ui.calculators.adapter.RecyclerViewAdapter;

public class CalculatorsFragment extends Fragment {

    private CalculatorsViewModel calculatorsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculatorsViewModel =
                new ViewModelProvider(this).get(CalculatorsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_calculators, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(calculatorsViewModel.initData());

        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        return root;
    }





}

package com.example.diplomandroid.ui.journals.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomandroid.R;
import com.example.diplomandroid.ui.journals.Journals;
import com.example.diplomandroid.ui.journals.calories.CaloriesJournalActivity;
import com.example.diplomandroid.ui.journals.distance.DistanceJournalActivity;
import com.example.diplomandroid.ui.journals.steps.StepsJournalActivity;
import com.example.diplomandroid.ui.journals.weight.WeightJournalActivity;

import java.util.List;

public class JournalsRecyclerViewAdapter extends RecyclerView.Adapter<JournalsRecyclerViewAdapter.JournalsViewHolder> {

    private final List<Journals> data;

    public JournalsRecyclerViewAdapter(List<Journals> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public JournalsRecyclerViewAdapter.JournalsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_calculators, viewGroup, false);
        return new JournalsRecyclerViewAdapter.JournalsViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull JournalsRecyclerViewAdapter.JournalsViewHolder currencyViewHolder, int i) {
        //Заполнение элементов view данными из списка обьектов
        currencyViewHolder.journalImage.setImageResource(data.get(i).getImageResource());
        currencyViewHolder.journalName.setText(data.get(i).getName());
        currencyViewHolder.journalDescription.setText(data.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class JournalsViewHolder extends RecyclerView.ViewHolder {
        ImageView journalImage;
        TextView journalName;
        TextView journalDescription;
        CardView cardView;

        JournalsViewHolder(@NonNull View itemView) {
            super(itemView);
            journalImage = itemView.findViewById(R.id.calculator_image);
            journalName = itemView.findViewById(R.id.calculator_name);
            journalDescription = itemView.findViewById(R.id.calculator_description);
            cardView = itemView.findViewById(R.id.card_view_calculators);
            cardView.setOnClickListener((View v) -> {
                if (journalName.getText().equals("Distance journal")) {
                    Intent intent = new Intent(itemView.getContext(), DistanceJournalActivity.class);
                    itemView.getContext().startActivity(intent);
                } else if (journalName.getText().equals("Steps journal")) {
                    Intent intent = new Intent(itemView.getContext(), StepsJournalActivity.class);
                    itemView.getContext().startActivity(intent);
                } else if (journalName.getText().equals("Calories journal")) {
                    Intent intent = new Intent(itemView.getContext(), CaloriesJournalActivity.class);
                    itemView.getContext().startActivity(intent);
                } else if (journalName.getText().equals("Weight journal")) {
                    Intent intent = new Intent(itemView.getContext(), WeightJournalActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

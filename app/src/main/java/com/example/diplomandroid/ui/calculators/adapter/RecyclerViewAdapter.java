package com.example.diplomandroid.ui.calculators.adapter;

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
import com.example.diplomandroid.ui.calculators.Calculators;
import com.example.diplomandroid.ui.calculators.bmi.BodyMassIndexActivity;
import com.example.diplomandroid.ui.calculators.dca.DailyCaloriesAmountActivity;
import com.example.diplomandroid.ui.calculators.dwa.DailyWaterAmountActivity;
import com.example.diplomandroid.ui.calculators.iw.IdealWeightActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CalculatorsViewHolder> {

    private final List<Calculators> data;

    public RecyclerViewAdapter(List<Calculators> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CalculatorsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_calculators, viewGroup, false);
        return new CalculatorsViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull CalculatorsViewHolder currencyViewHolder, int i) {
        //Заполнение элементов view данными из списка обьектов
        currencyViewHolder.calculatorImage.setImageResource(data.get(i).getImageResource());
        currencyViewHolder.calculatorName.setText(data.get(i).getName());
        currencyViewHolder.calculatorDescription.setText(data.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class CalculatorsViewHolder extends RecyclerView.ViewHolder {
        ImageView calculatorImage;
        TextView calculatorName;
        TextView calculatorDescription;
        CardView cardView;

        CalculatorsViewHolder(@NonNull View itemView) {
            super(itemView);
            calculatorImage = itemView.findViewById(R.id.calculator_image);
            calculatorName = itemView.findViewById(R.id.calculator_name);
            calculatorDescription = itemView.findViewById(R.id.calculator_description);
            cardView = itemView.findViewById(R.id.card_view_calculators);
            cardView.setOnClickListener((View v) -> {
                if (calculatorName.getText().equals("Body mass index")) {
                    Intent intent = new Intent(itemView.getContext(), BodyMassIndexActivity.class);
                    itemView.getContext().startActivity(intent);
                } else if (calculatorName.getText().equals("Daily calories amount")) {
                    Intent intent = new Intent(itemView.getContext(), DailyCaloriesAmountActivity.class);
                    itemView.getContext().startActivity(intent);
                } else if (calculatorName.getText().equals("Daily water amount")) {
                    Intent intent = new Intent(itemView.getContext(), DailyWaterAmountActivity.class);
                    itemView.getContext().startActivity(intent);
                } else if (calculatorName.getText().equals("Ideal weight")) {
                    Intent intent = new Intent(itemView.getContext(), IdealWeightActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}

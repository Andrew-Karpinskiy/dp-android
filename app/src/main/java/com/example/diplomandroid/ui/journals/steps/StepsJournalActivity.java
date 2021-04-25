package com.example.diplomandroid.ui.journals.steps;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;

import java.util.Calendar;
import java.util.Date;

public class StepsJournalActivity extends AppCompatActivity {
    private StepsJournalViewModel stepsJournalViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_journal);

        stepsJournalViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StepsJournalViewModel.class);

        TextView newEntity = findViewById(R.id.sjNewButton);
        newEntity.setOnClickListener(view -> {
            LayoutInflater li = LayoutInflater.from(this);
            View promptsView = li.inflate(R.layout.new_entity_dialog, null);
            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
            mDialogBuilder.setView(promptsView);
            EditText userInput = promptsView.findViewById(R.id.amount_input);
            DatePicker datePicker = promptsView.findViewById(R.id.datePicker);
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok,
                            (dialog, id) -> {
                                int day = datePicker.getDayOfMonth();
                                int month = datePicker.getMonth();
                                int year = datePicker.getYear();
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, month, day);
                                Date date = calendar.getTime();
                                Integer stepsAmount = Integer.parseInt(userInput.getText().toString());
                                stepsJournalViewModel.saveSteps(this, stepsAmount, date.toString());
                            })
                    .setNegativeButton(R.string.cancel,
                            (dialog, id) -> dialog.cancel());
            AlertDialog alertDialog = mDialogBuilder.create();
            alertDialog.show();
        });

        TextView range = findViewById(R.id.sjSelectButton);
        range.setOnClickListener(view -> {
            final String[] labelsArray = {"7", "30"};
            final boolean[] checkedItemsArray = {false, false};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Выберите любимое имя кота")
                    .setSingleChoiceItems(labelsArray, -1,
                            (dialog, item) -> {
                                checkedItemsArray[item] = true;
                            })
                    .setPositiveButton(R.string.ok, (dialog, id) -> {
                        if (checkedItemsArray[0]) {
                            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> {
                        dialog.cancel();
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });


//        Calendar calendar = Calendar.getInstance();
//        Date d1 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d2 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d3 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d4 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d5 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d6 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d7 = calendar.getTime();
//        Date d8 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d9 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d10 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d11 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d12 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d13 = calendar.getTime();
//        calendar.add(Calendar.DATE, 1);
//        Date d14 = calendar.getTime();
//
//        GraphView graph = findViewById(R.id.sjGraph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
//                new DataPoint(d1, 1),
//                new DataPoint(d2, 5),
//                new DataPoint(d3, 7),
//                new DataPoint(d4, 8),
//                new DataPoint(d5, 9),
//                new DataPoint(d6, 10),
//                new DataPoint(d7, 12),
//                new DataPoint(d8, 14),
//                new DataPoint(d9, 15),
//                new DataPoint(d10, 16),
//                new DataPoint(d11, 17),
//                new DataPoint(d12, 18),
//                new DataPoint(d13, 19),
//                new DataPoint(d14, 20)
//        });
//        series.setDrawDataPoints(true);
//        series.setColor(Color.RED);
//        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
//        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
//        graph.addSeries(series);
//
//        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
//        graph.getGridLabelRenderer().setNumHorizontalLabels(4); // only 4 because of the space
//
//// set manual x bounds to have nice steps
//        graph.getViewport().setMinX(d1.getTime());
//        graph.getViewport().setMaxX(d14.getTime());
//        //graph.getViewport().setMaxY(13.5);
//        graph.getViewport().setXAxisBoundsManual(true);
//
//        graph.getGridLabelRenderer().setHumanRounding(false);
//
//        series.setOnDataPointTapListener((series1, dataPoint) -> Toast.makeText(graph.getContext(), "Data : On Data Point clicked: " + new Date((long) dataPoint.getX()).toString() + " " + dataPoint.getY(), Toast.LENGTH_SHORT).show());
    }
}
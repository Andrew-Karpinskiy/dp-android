package com.example.diplomandroid.ui.journals.steps;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomandroid.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StepsJournalActivity extends AppCompatActivity {
    private StepsJournalViewModel stepsJournalViewModel;
    public static Map<String, String> journalResponses = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
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
            builder.setTitle(R.string.range)
                    .setSingleChoiceItems(labelsArray, -1,
                            (dialog, item) -> {
                                checkedItemsArray[item] = true;
                            })
                    .setPositiveButton(R.string.ok, (dialog, id) -> {
                        Calendar cal = Calendar.getInstance();
                        if (checkedItemsArray[0]) {
                            cal.add(Calendar.DATE, -7);
                            Date date = cal.getTime();
                            stepsJournalViewModel.getSteps(this, date.toString());
                        } else {
                            cal.add(Calendar.DATE, -30);
                            Date date = cal.getTime();
                            stepsJournalViewModel.getSteps(this, date.toString());
                        }
                    })
                    .setNegativeButton(R.string.cancel, (dialog, id) -> {
                        dialog.cancel();
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });


        GraphView graph = findViewById(R.id.sjGraph);
        TreeMap<Date, Integer> data = new TreeMap<>();
        if (journalResponses.size() > 0) {
            for (String key : journalResponses.keySet()) {
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(key);
                    Integer value = Integer.valueOf(journalResponses.get(key));
                    data.put(date, value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(data.toString());
            if (data.size() > 0) {
                List<DataPoint> dataPoints = new ArrayList<>();
                for (Date date : data.keySet()) {
                    dataPoints.add(new DataPoint(date, data.get(date)));
                }
                System.out.println(dataPoints);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints.toArray(new DataPoint[0]));
                series.setDrawDataPoints(true);
                series.setColor(Color.RED);
                graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
                graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
                graph.addSeries(series);
                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
                graph.getGridLabelRenderer().setNumHorizontalLabels(4); // only 4 because of the space
                graph.getGridLabelRenderer().setNumVerticalLabels(4); // only 4 because of the space
                graph.getViewport().setMinX(data.firstKey().getTime());
                graph.getViewport().setMaxX(data.lastKey().getTime());
                graph.getViewport().setMinY(data.get(data.firstKey()));
                graph.getViewport().setMaxY(data.get(data.lastKey()));
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getGridLabelRenderer().setHumanRounding(false);
                series.setOnDataPointTapListener((series1, dataPoint) -> Toast.makeText(graph.getContext(), "Data : On Data Point clicked: " + new Date((long) dataPoint.getX()).toString() + " " + dataPoint.getY(), Toast.LENGTH_SHORT).show());
            }
        }
    }
}
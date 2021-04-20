package com.example.diplomandroid.ui.journals.weight;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomandroid.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class WeightJournalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weight_journal);

        GraphView graph = findViewById(R.id.wjGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(2, 3),
//                new DataPoint(0, 0),
//                new DataPoint(0, 0),
//                new DataPoint(2, 3),
                new DataPoint(100, 100)
        });
        series.setDrawDataPoints(true);
        series.setColor(Color.RED);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        graph.addSeries(series);
    }
}
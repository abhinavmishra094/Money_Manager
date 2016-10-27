package com.example.abhin.money_manager;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class daily_graph extends Fragment {


    public daily_graph() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_daily_graph, container, false);
        LineChart lineChart = (LineChart) view.findViewById(R.id.line);
        LineData lineData = new LineData(getXAxisValues(), getDataSet());
        lineChart.setData(lineData);
        lineChart.setDescription("Transaction in Current Day");
        lineChart.animateXY(2000, 2000);
        lineChart.invalidate();



        return  view;
    }
    private ArrayList<LineDataSet> getDataSet() {
        ArrayList<LineDataSet> dataSets = null;

        ArrayList<Entry> valueSet1 = new ArrayList<>();
        Entry v1e1 = new Entry(0.00f, 0);
        valueSet1.add(v1e1);
        Entry v1e2 = new Entry(40.000f, 1);
        valueSet1.add(v1e2);
        Entry v1e3 = new Entry(60.000f, 2);
        valueSet1.add(v1e3);
        Entry v1e4 = new Entry(30.000f, 3);
        valueSet1.add(v1e4);
        Entry v1e5 = new Entry(90.000f, 4);
        valueSet1.add(v1e5);
        Entry v1e6 = new Entry(100.000f, 5);
        valueSet1.add(v1e6);



        LineDataSet lineDataSet1 = new LineDataSet(valueSet1, "Money Spend per month");
        lineDataSet1.setColor(Color.rgb(0, 0, 155));
        /*LineDataSet lineDataSet2 = new LineDataSet(valueSet2, "Brand 2");
        lineDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
*/
        dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        //dataSets.add(lineDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("6 Am");
        xAxis.add("10 Am");
        xAxis.add("2 Pm");
        xAxis.add("6 pm");
        xAxis.add("10 pm");
        xAxis.add("12 pm");
        /*xAxis.add("JUN");
        xAxis.add("JULY");
        xAxis.add("AUGUST");
        xAxis.add("SEPTEMBER");
        xAxis.add("OCTOBER");
        xAxis.add("NOVEMBER");
        xAxis.add("DECEMBER");*/
        return xAxis;
    }
}


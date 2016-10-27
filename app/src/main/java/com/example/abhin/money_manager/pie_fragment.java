package com.example.abhin.money_manager;


import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class pie_fragment extends Fragment {

    PieChart pieChart;
    int yData[] ={60,15,25,50};
    ArrayList<Integer> y;
    String xData[] ={"Food","Shopping","Fuel","Misc"};

    MyDatabase myDatabase;
    Cursor cursor;
    HashMap<String,Integer> set;

    public pie_fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pie_fragment, container, false);
        pieChart = (PieChart) view.findViewById(R.id.g_pie);
        pieChart.setDescription("");
        pieChart.setDrawSliceText(false);


       /* y = new ArrayList<>();
        set = new HashMap<>() ;
       // new aysc().execute();

        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
        cursor = myDatabase.getTransactions();
        while (cursor.moveToNext())
        {
            set.put(cursor.getString(3),cursor.getInt(1));
        }
        for (Map.Entry<String, Integer> e : set.entrySet()) {
            Object key = e.getKey();
            if(e.getKey().toString()=="Food")
            {
                xData[0]= "Food";
            }
            else if(e.getKey().toString()=="Shopping")
            {
                xData[1]= "Shopping";
            }
            else if(e.getKey().toString()=="Fuel")
            {
                xData[2]= "Fuel";
            }
            else if(e.getKey().toString()=="Misc")
            {
                xData[3]= "Misc";
            }
            Object value = e.getValue();
          //  xData[i++]= key.toString();
            switch (key.toString())
            {
                case "Food":
                    yData[0]+=Integer.parseInt(value.toString());
                    break;
                case "Shopping":
                    yData[1]+=Integer.parseInt(value.toString());
                    break;
                case "Fuel":
                    yData[2]+=Integer.parseInt(value.toString());
                    break;
                case "Misc":
                    yData[3]+=Integer.parseInt(value.toString());
                    break;
            }
        }*/

       // PieData pieData = new PieData();
        //pieChart.animateY(5000);
        pieChart.setBackgroundColor(Color.parseColor("#55656C"));
        pieChart.setUsePercentValues(true);
        //pieChart.setDescription("Mney Spend On");

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                if (e == null)
                    return;
            }

            @Override
            public void onNothingSelected() {

            }
        });
        addData();
        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);
        legend.setXEntrySpace(7);
        legend.setYEntrySpace(5);
        return view;
    }

    private void addData() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        // create pie data set
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(2);

        // add many colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        // instantiate pie data object now
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);

        pieChart.setData(data);

        // undo all highlights
        pieChart.highlightValues(null);

        // update pie chart
        pieChart.invalidate();
    }
/*
    public class aysc extends AsyncTask<Void,Void,Void>
    {


        @Override
        protected Void doInBackground(Void... voids) {
           myDatabase.open();
            return null;
        }
    }*/
}

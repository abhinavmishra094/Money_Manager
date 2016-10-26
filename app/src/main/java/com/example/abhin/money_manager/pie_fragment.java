package com.example.abhin.money_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;



public class pie_fragment extends Fragment {

    PieChart pieChart;

    public pie_fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pie_fragment, container, false);
        pieChart = (PieChart) view.findViewById(R.id.g_pie);
        PieData pieData = new PieData();


        return view;
    }

}

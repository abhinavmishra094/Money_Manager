package com.example.abhin.money_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;


/**
 * A simple {@link Fragment} subclass.
 */
public class monthly_graph extends Fragment {


    public monthly_graph() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monthly_graph, container, false);
        BarChart barChart = (BarChart) view.findViewById(R.id.g_m);

        return view;
    }

}

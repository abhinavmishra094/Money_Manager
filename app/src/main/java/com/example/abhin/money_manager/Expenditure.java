package com.example.abhin.money_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Expenditure extends Fragment {


    public Expenditure() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenditure, container, false);
        ((Options_Menu) getActivity()).setActionBarTitle("Custom Expenditure");


        return view;
    }

}

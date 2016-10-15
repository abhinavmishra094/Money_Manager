package com.example.abhin.money_manager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;


    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        arrayList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.settings);
        arrayList.add("Settings");
        arrayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);


        return  view;
    }

}

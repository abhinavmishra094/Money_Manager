package com.example.abhin.money_manager;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add_transaction extends Fragment {

    Dialog dialog;

    EditText amt;
    Spinner cate, type;
    Button add, cancel;
    MyDatabase myDatabase;
    ArrayList<String> type3, Category;
    ArrayAdapter<String> arrayAdapter, arrayAdapter1;
    String category;
    int img;
    String credit;
    int amount;
    String date;
    String time;
    Time time1;

    public Add_transaction() {
        // Required empty public constructor
    }



    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
       // dialog = null;
        //AlertDialog.Builder aBuilder = new AlertDialog.Builder(getActivity());
        //aBuilder.setTitle("Add Transactions");
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_add_transaction, null);
        amt = (EditText) view.findViewById(R.id.amount);
        type = (Spinner) view.findViewById(R.id.type);
        cate = (Spinner) view.findViewById(R.id.Creditdebit);
        add = (Button) view.findViewById(R.id.add);
        cancel = (Button) view.findViewById(R.id.cancel);
        img = R.drawable.ic_account_balance_black_48dp;
        type3 = new ArrayList<String>();
        Category = new ArrayList<String>();
        Category.add("Category");
        Category.add("Food");
        Category.add("Shopping");
        Category.add("Fuel");
        Category.add("Misc");

        type3.add("Type of Transaction");
        type3.add("Debit");
        type3.add("Credit");
        arrayAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Category);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, type3);
        cate.setAdapter(arrayAdapter1);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
        type.setAdapter(arrayAdapter);
        cate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (Category.get(i).equals("Category")) {


                } else {
                    category = Category.get(i);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (type3.get(i).equals("Type of Transaction")) {

                } else {
                    credit = type3.get(i);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                Date date1 = new Date();

                time = date1.getHours() + ":" + date1.getMinutes();
                date = date1.getDay() + "/" + date1.getMonth() + "/" + date1.getYear();


                amount = Integer.parseInt(amt.getText().toString());


                switch (category) {
                    case "Food":
                        img = R.drawable.ic_account_balance_black_48dp;
                        break;

                    case "Shopping":
                        img = R.drawable.ic_account_balance_wallet_black_48dp;
                        break;
                    case "Fuel":
                        img = R.drawable.ic_account_balance_black_48dp;
                        break;
                    case "Misc":
                        img = R.drawable.ic_account_circle_black_48dp;
                        break;


                }


                myDatabase.insertTransaction(amount, credit, category, date, time, img);



                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);




            }
        });
       /* cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });*/


       // aBuilder.setView(view);
       // dialog = aBuilder.create();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDatabase.close();
    }
}

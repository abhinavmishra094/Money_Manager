package com.example.abhin.money_manager;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Transactions extends Fragment {

    ListView listView;
    SimpleCursorAdapter transactions;
    MyDatabase myDatabase;
    Cursor cursor_transactions;
    FloatingActionButton add;

    public Transactions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        listView = (ListView) view.findViewById(R.id.daily);

        Fragment_Graph fragment_graph = new Fragment_Graph();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.graph,fragment_graph);
        fragmentTransaction.commit();

        add = (FloatingActionButton) view.findViewById(R.id.add);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
        cursor_transactions = myDatabase.getTransactionsReverse();

        transactions = new SimpleCursorAdapter(getActivity(), R.layout.daily_row, cursor_transactions, new String[]{"image", "amount", "time","place"}, new int[]{R.id.imgv, R.id.tr1, R.id.ti,R.id.ps});

        add.setImageResource(R.drawable.ic_add_white_48dp);


        listView.setAdapter(transactions);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),AddTranscation.class);

                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        cursor_transactions = myDatabase.getTransactions();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDatabase.close();
    }
}

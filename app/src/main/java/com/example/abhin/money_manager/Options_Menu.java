package com.example.abhin.money_manager;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Options_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options__menu);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String selected = bundle.getString("option_selected");

        Settings settings = new Settings();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);

        switch (selected)
        {
            case "settings":

                fragmentTransaction.add(R.id.options,settings);
                fragmentTransaction.commit();
                break;
        }

    }
}

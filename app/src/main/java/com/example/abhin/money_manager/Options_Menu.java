package com.example.abhin.money_manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Options_Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options__menu);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String selected = bundle.getString("option_selected");

        Settings settings = new Settings();
        CreditFragment credit_fragment = new CreditFragment();
        Expenditure expenditure = new Expenditure();
        DailyExpenditure dailyExpenditure = new DailyExpenditure();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        switch (selected) {
            case "settings":

                fragmentTransaction.add(R.id.options, settings);
                fragmentTransaction.commit();
                break;
            case "credit":
                fragmentTransaction.add(R.id.options, credit_fragment);
                fragmentTransaction.commit();


                break;
            case "expenditure":
                fragmentTransaction.add(R.id.options, expenditure);
                fragmentTransaction.commit();


                break;
            case "daily":
                fragmentTransaction.add(R.id.options, dailyExpenditure);
                fragmentTransaction.commit();


                break;
        }

    }



    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }


        return super.onOptionsItemSelected(item);
    }

}

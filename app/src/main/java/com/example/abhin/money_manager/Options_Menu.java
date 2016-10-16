package com.example.abhin.money_manager;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Options_Menu extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options__menu);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String selected = bundle.getString("option_selected");

        Settings settings = new Settings();
        Credit_fragment credit_fragment = new Credit_fragment();
        Expenditure expenditure = new Expenditure();
        DailyExpenditure dailyExpenditure = new DailyExpenditure();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.addToBackStack(null);
        //fragmentManager.addOnBackStackChangedListener(this);
      //  shouldDisplayHomeUp();

        switch (selected)
        {
            case "settings":

                fragmentTransaction.add(R.id.options,settings);
                fragmentTransaction.commit();
                break;
            case "credit":
                fragmentTransaction.add(R.id.options,credit_fragment);
                fragmentTransaction.commit();



                break;
            case "expenditure":
                fragmentTransaction.add(R.id.options,expenditure);
                fragmentTransaction.commit();



                break;
            case "daily":
                fragmentTransaction.add(R.id.options,dailyExpenditure);
                fragmentTransaction.commit();



                break;
        }

    }

   /* private void shouldDisplayHomeUp() {
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }*/

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

 /*   @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }

    @Override
    public void onBackStackChanged() {

        shouldDisplayHomeUp();
    }*/
}

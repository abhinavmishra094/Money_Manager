package com.example.abhin.money_manager;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class AddTranscation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transcation);
        Add_transaction addTranscation = new Add_transaction();
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameadd,addTranscation);
        fragmentTransaction.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //Intent intent = new Intent(AddTranscation.this, MainActivity.class);
                //startActivity(intent);
                finish();
        }




        return super.onOptionsItemSelected(item);
    }
}

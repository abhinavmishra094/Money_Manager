package com.example.abhin.money_manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment_Graph fragment_graph = new Fragment_Graph();
        Fragment_ViewPager fragment_viewPager = new Fragment_ViewPager();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.graph,fragment_graph);
        fragmentTransaction.add(R.id.viewpager,fragment_viewPager);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        Intent intent = new Intent(MainActivity.this,Options_Menu.class);
        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_settings:
                intent.putExtra("option_selected","settings");
                startActivity(intent);

                break;
            case R.id.report_bugs:
               // intent.putExtra("option_selected","report_bugs");
                //startActivity(intent);
                break;
            case R.id.suggest_feautre:
                //intent.putExtra("option_selected","suggest_feature");
               // startActivity(intent);
                break;
            case R.id.about_us:
                //intent.putExtra("option_selected","about_us");
                //startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this,Options_Menu.class);


        switch (id)
        {
            case  R.id.nav_credit:

                intent.putExtra("option_selected","credit");
                startActivity(intent);
                break;

            case  R.id.nav_custom_expenditure:

                break;

            case  R.id.nav_daily:

                break;

            case  R.id.nav_expend_limit:

            break;

            case  R.id.nav_monthly:


                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

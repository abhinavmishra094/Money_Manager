package com.example.abhin.money_manager;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;


public class Fragment_Graph extends Fragment {

    ViewPager viewPager;
    ArrayList<Fragment> arrayList;
    GraphPager graphPager;
    TabLayout mytab;

    public  class  GraphPager extends FragmentPagerAdapter {
        public GraphPager(FragmentManager fm,ArrayList<Fragment> arrayList1) {
            super(fm);

            arrayList = arrayList1;


        }

        @Override
        public Fragment getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
           // return R.drawable.ic_radio_button_checked_black_24dp;
        }
    }

    public Fragment_Graph() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__graph, container, false);


        viewPager = (ViewPager) view.findViewById(R.id.viewpager_graph);

       daily_graph dailyGraph = new daily_graph();
        pie_fragment piefragment = new pie_fragment();
        monthly_graph monthlyGraph =  new monthly_graph();
        arrayList = new ArrayList<Fragment>();
        arrayList.add(piefragment);
        arrayList.add(dailyGraph);
        arrayList.add(monthlyGraph);


        graphPager = new GraphPager(getFragmentManager(),arrayList);

        mytab = (TabLayout) view.findViewById(R.id.mytab);
        viewPager.setAdapter(graphPager);

        mytab.setupWithViewPager(viewPager);
        mytab.setSelectedTabIndicatorColor(00);
        mytab.getTabAt(0).setIcon(R.drawable.ic_radio_button_checked_black_24dp);
        mytab.getTabAt(1).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);
        mytab.getTabAt(2).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);

        new setAdapterTask().execute();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0)
                {
                    mytab.getTabAt(0).setIcon(R.drawable.ic_radio_button_checked_black_24dp);
                    mytab.getTabAt(1).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);
                    mytab.getTabAt(2).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);

                }

                else if (position == 1) {
                    mytab.getTabAt(1).setIcon(R.drawable.ic_radio_button_checked_black_24dp);
                    mytab.getTabAt(0).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);
                    mytab.getTabAt(2).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);

                } else if (position ==2) {
                    mytab.getTabAt(2).setIcon(R.drawable.ic_radio_button_checked_black_24dp);
                    mytab.getTabAt(1).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);
                    mytab.getTabAt(0).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
    private class setAdapterTask extends AsyncTask<Void,Void,Void>

    {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            viewPager.setAdapter(graphPager);
            mytab.setupWithViewPager(viewPager);
            mytab.setSelectedTabIndicatorColor(00);
            mytab.getTabAt(0).setIcon(R.drawable.ic_radio_button_checked_black_24dp);
            mytab.getTabAt(1).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);
            mytab.getTabAt(2).setIcon(R.drawable.ic_radio_button_unchecked_black_24dp);

        }
    }

}

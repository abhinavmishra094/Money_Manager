package com.example.abhin.money_manager;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment_ViewPager extends Fragment {

    ViewPager viewPager ;
    MyAdapter myAdapter;
    TabLayout tabLayout;
    public  class  MyAdapter extends FragmentPagerAdapter
    {
        String arr[] = {"one","two","three","four"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return arr.length;
        }
    }



    public Fragment_ViewPager() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__view_pager, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager1);
        tabLayout = (TabLayout) view.findViewById(R.id.mytab);
        myAdapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);




        return  view;
    }

}

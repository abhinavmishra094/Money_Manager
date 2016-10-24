package com.example.abhin.money_manager;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_ViewPager extends Fragment {


    CoordinatorLayout coordinatorLayout;
    MyAdapter myAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    public Fragment_ViewPager() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment__view_pager, null);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager1);
        tabLayout = (TabLayout) view.findViewById(R.id.tab1);
        myAdapter = new MyAdapter(getFragmentManager());
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(4);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_view_list_black_48dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_account_balance_black_48dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_people_black_48dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.money);


        return view;
    }

    public class MyAdapter extends FragmentPagerAdapter {
        String arr[] = {"", "", "", ""};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {


                return new Transactions();

            } else if (position == 1) {

                return new AccountBalace();
            } else if (position == 2) {


                return new BorrowLoan();
            } else if (position == 3) {


                return new emiclaculator();
            } else
                return new Transactions();


        }

        @Override
        public int getCount() {
            return arr.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arr[position];
        }
    }

}

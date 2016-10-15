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
        String arr[] = {"Daily","Weekly","Monthly","Yearly"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

          if(position==0)
          {


              return new DailyFragment();

          }
            else  if (position==1)
          {

              return new Fragment_Weekly();
          }
          else  if (position==2)
          {


              return new Fragment_Monthly();
          }
          else  if (position==3)
          {


              return new Yearly();
          }
            else
          return new DailyFragment();


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



    public Fragment_ViewPager() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment__view_pager,null);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager11);
       tabLayout = (TabLayout) view.findViewById(R.id.mytab1);
        myAdapter = new MyAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
      tabLayout.setupWithViewPager(viewPager);




        return  view;
    }

}

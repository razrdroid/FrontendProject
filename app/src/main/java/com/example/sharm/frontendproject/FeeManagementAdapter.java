package com.example.sharm.frontendproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sharm.frontendproject.Fragments.FragmentBankDetails;
import com.example.sharm.frontendproject.Fragments.FragmentBatch;
import com.example.sharm.frontendproject.Fragments.FragmentHistory;
import com.example.sharm.frontendproject.Fragments.FragmentMiddle;
import com.example.sharm.frontendproject.Fragments.LastFragment;

/**
 * Created by sharm on 14-06-2017.
 */

public class FeeManagementAdapter
    extends FragmentPagerAdapter{


    public FeeManagementAdapter(FragmentManager fm) {
        super(fm);
    }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new FragmentHistory();
            }
            else{
                return new FragmentBankDetails();
            }


        }

        @Override
        public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position){
        switch(position){
            case 0:
                return "History";
            case 1:
                return "Bank Details";

        }
        return null;
    }
}

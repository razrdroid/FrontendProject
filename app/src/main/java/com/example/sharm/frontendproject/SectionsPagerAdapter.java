package com.example.sharm.frontendproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sharm.frontendproject.Fragments.FragmentBatch;
import com.example.sharm.frontendproject.Fragments.FragmentMiddle;
import com.example.sharm.frontendproject.Fragments.LastFragment;

/**
 * Created by sharm on 12-06-2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==1){
            return new FragmentMiddle();
        }
       else if(position==2){
            return new LastFragment();
        }
        else if(position==0) {
            return new FragmentBatch();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
    public CharSequence getPageTitle(int position){
        switch(position){
            case 0:
                return "Batches";
            case 1:
                return "Tests";
            case 2:
                return "Reports";
        }
        return null;
    }
}

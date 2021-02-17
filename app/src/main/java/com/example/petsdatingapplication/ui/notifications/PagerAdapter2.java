package com.example.petsdatingapplication.ui.notifications;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter2 extends FragmentPagerAdapter {

    private final int numOfTabs2;

    public PagerAdapter2(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs2 = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ConnectionsFragment();
            default:
                return new MessagesFragment();
        }
    }

    @Override
    public int getCount() {
        return numOfTabs2;
    }
}

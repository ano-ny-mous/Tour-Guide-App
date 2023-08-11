package com.example.android.tourguideapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    public SimpleFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HistoricalPlacesFragment();
            case 1:
                return new ShopingPlacesFragment();
            case 2:
                return new HotelsFragment();
            default:
                return new FoodFragment();

        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

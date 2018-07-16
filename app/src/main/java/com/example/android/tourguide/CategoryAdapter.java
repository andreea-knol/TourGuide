package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new RestaurantsFragment();
            case 2:
                return new ParksFragment();
            case 3:
                return new MuseumsFragment();
            case 4:
                return new HistoricalFragment();
            case 5:
                return new ShoppingFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}


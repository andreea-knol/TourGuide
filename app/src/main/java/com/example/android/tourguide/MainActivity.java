package com.example.android.tourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Displays a {@link ViewPager} where each page shows a different list of touristic locations.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.restaurant);
        tabLayout.getTabAt(2).setIcon(R.mipmap.park);
        tabLayout.getTabAt(3).setIcon(R.mipmap.museum);
        tabLayout.getTabAt(4).setIcon(R.mipmap.history);
        tabLayout.getTabAt(5).setIcon(R.mipmap.shopping);
    }
}
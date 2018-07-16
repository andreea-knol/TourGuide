package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalFragment extends Fragment {


    public HistoricalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Find the view that displays the title of the category
        TextView title = rootView.findViewById(R.id.list_title);
        // Set the title of the list to correspond to the current category
        title.setText(R.string.category_history);
        // Set the background of the title view to correspond to the color of this category
        int color = ContextCompat.getColor(getContext(), R.color.category_historical);
        title.setBackgroundColor(color);

        // Create an ArrayList of locations
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getResources().getString(R.string.historical_banffy),
                getResources().getString(R.string.historical_banffy_description),
                getResources().getString(R.string.historical_banffy_address),
                R.drawable.historical_banffy));
        locations.add(new Location(getResources().getString(R.string.historical_mateicorvin),
                getResources().getString(R.string.historical_mateicorvin_description),
                getResources().getString(R.string.historical_mateicorvin_address),
                R.drawable.historical_mateicorvin));
        locations.add(new Location(getResources().getString(R.string.historical_museumsquare),
                getResources().getString(R.string.historical_museumsquare_description),
                getResources().getString(R.string.historical_museumsquare_address),
                R.drawable.historical_museumsquare));
        locations.add(new Location(getResources().getString(R.string.historical_tailorstower),
                getResources().getString(R.string.historical_tailorstower_description),
                getResources().getString(R.string.historical_tailorstower_address),
                R.drawable.historical_tailorstower));
        locations.add(new Location(getResources().getString(R.string.historical_theater),
                getResources().getString(R.string.historical_theater_description),
                getResources().getString(R.string.historical_theater_address),
                R.drawable.historical_theater));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Locations}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_historical);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

}

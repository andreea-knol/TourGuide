package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/*
* {@link LocationAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Location} objects.
* */

public class LocationAdapter extends ArrayAdapter<Location>{

    /** this is the resource ID for the background color for this list of locations **/
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param locations A List of Location objects to display in a list
     */
    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResourceId){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    /**
     * This method provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position represents the position in the list of data that should be displayed in
     *                 the list item view
     * @param convertView represents the recycled view to populate
     * @param parent represents the parent ViewGroup that is used for inflation
     * @return the View for the position in the AdapterView
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get the name from the current Location object and set this text on
        // the name TextView
        nameTextView.setText(currentLocation.getName());

        // Find the TextView in the list_item.xml layout with the ID description_text_view
        TextView descriptionTextView = listItemView.findViewById(R.id.description_text_view);
        // Get the description from the current Location object and set this text on
        // the description TextView
        descriptionTextView.setText(currentLocation.getDescription());

        // Find the TextView in the list_item.xml layout with the ID address_text_view
        TextView addressTextView = listItemView.findViewById(R.id.address_text_view);
        // Get the address from the current Location object and set this text on
        // the address TextView
        addressTextView.setText(currentLocation.getAddress());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = listItemView.findViewById(R.id.image);
        // Check if image was provided for this word or not
        imageView.setImageResource(currentLocation.getImageResourceId());

        // find the vertical layout that contains the info about the location
        // set the background color to be the one specific for each category
        LinearLayout locationInfoLayout = listItemView.findViewById(R.id.location_layout);
        // find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        locationInfoLayout.setBackgroundColor(color);

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }
}

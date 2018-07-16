package com.example.android.tourguide;


public class Location {

    /** The name of the location**/
    private String mName;
    /** The description of the location**/
    private String mDescription;
    /** The address of the location**/
    private String mAddress;
    /** The image resource ID for the location**/
    private int mImageResourceId;

    /**
     * This is the constructor that takes four parameters
     * @param name is the name of the location
     * @param description is the description of the location
     * @param address is the address of the location
     * @param imageResourceId is the image resource ID of the location
     */
    public Location(String name, String description, String address, int imageResourceId) {
        mName = name;
        mDescription = description;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "mName ='" + mName + '\'' +
                ", mDescription ='" + mDescription + '\'' +
                ", mAddress =" + mAddress +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}

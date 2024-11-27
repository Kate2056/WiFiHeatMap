package com.softwareengineering.wifiheatmap.entities;
import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class LocationTracker implements LocationListener{
    Location location;
    private double latitude;
    private double longitude;
    private Boolean gpsEnabled = false;
    private static LocationManager locationManager;
    private final Context mContext;
    private final long MIN_DISTANCE = 1;   //Minimum distance to change updates is 10 meters
    private final float MIN_TIME = 0.1f; //Minimum time between updates is 1 minute

    public LocationTracker(Context context){
        this.mContext = context;
        getLocation();
    }

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location){

        }
    };

    public Location getLocation(){
        try{
            locationManager = (LocationManager) mContext.getSystemService((Context.LOCATION_SERVICE));

            //Checks if GPS are enabled
            gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if(gpsEnabled){
                location = null;
                if(location == null){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_DISTANCE, MIN_TIME, this);
                }if(locationManager != null){
                    location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if(location != null){
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
            }
        }catch(SecurityException e){
            e.printStackTrace();
        }
        return location;
    }

    public double getLatitude() {
        if(location != null) {
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public double getLongitude() {
        if(location != null){
            longitude = location.getLongitude();
        }
        return longitude;
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

}

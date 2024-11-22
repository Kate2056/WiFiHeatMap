package com.softwareengineering.wifiheatmap.UI;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softwareengineering.wifiheatmap.R;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mMapView;
    //private static final String MAPVIEW_BUNDLE_KEY = MAPS_API_KEY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap){
        googleMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Marker"));

    }
}
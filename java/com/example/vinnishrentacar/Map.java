package com.example.vinnishrentacar;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;


public class Map extends AppCompatActivity {


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    }
}

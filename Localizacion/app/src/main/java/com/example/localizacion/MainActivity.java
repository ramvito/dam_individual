package com.example.localizacion;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener{

    Button okButton;
    Button gpsButton;

    EditText longitude;
    EditText latitude;

    protected LocationManager locationManager;

    boolean enableGPS = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        okButton = (Button) findViewById(R.id.okButton);
        gpsButton = (Button) findViewById(R.id.gpsButton);

        longitude = (EditText) findViewById(R.id.longitudeText);
        latitude = (EditText) findViewById(R.id.latitudeText);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
                    0);
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0.0f, this);

        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableGPS = !enableGPS;
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), MapsActivity.class);

                intent.putExtra("Longitude", longitude.getText().toString());
                intent.putExtra("Latitude", latitude.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {

        if (enableGPS) {
            latitude.setText(Double.toString(location.getLatitude()));
            longitude.setText(Double.toString(location.getLongitude()));
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}

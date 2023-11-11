package com.kaveesha.mobileproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.widget.Button;
import android.widget.ImageButton;



public class dashboard extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private TextView locationTextView;
    private TextView weatherTextView;
    private TextView timeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Set the title and enable back button on the action bar
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //buttons
        //for diet plan
        Button button1= findViewById(R.id.dietp);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard.this,DietPlans.class);
                startActivity(intent);
            }
        });
        //workoutplans
        Button button2= findViewById(R.id.workoutp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard.this,WorkoutPlans.class);
                startActivity(intent);
            }
        });
        //Chart
        Button button3= findViewById(R.id.chartc);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard.this,BMIChart.class);
                startActivity(intent);
            }
        });
        //Logout
        Button button4= findViewById(R.id.logotd);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard.this,Splash.class);
                startActivity(intent);
            }
        });
        //image button
        ImageButton button5= findViewById(R.id.imageButtonStart);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dashboard.this,TodayWorkOut.class);
                startActivity(intent);
            }
        });



        // Initialize the TextViews

        locationTextView = findViewById(R.id.locationTextView);
        weatherTextView = findViewById(R.id.weatherTextView);
        timeTextView = findViewById(R.id.timeTextView);

        // Initialize location-related variables
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationRequest = createLocationRequest();

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult.getLastLocation() != null) {
                    double latitude = locationResult.getLastLocation().getLatitude();
                    double longitude = locationResult.getLastLocation().getLongitude();

                    // Update locationTextView with location name
                    String locationName = getLocationName(latitude, longitude);
                    locationTextView.setText(locationName);

                    // Fetch weather data based on latitude and longitude
                    fetchWeatherData(latitude, longitude);

                    // Update timeTextView with current time
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
                    String currentTime = sdf.format(new Date());
                    timeTextView.setText(currentTime);
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationUpdates();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    private void startLocationUpdates() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
    }

    private void stopLocationUpdates() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private LocationRequest createLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
    }

    private void fetchWeatherData(double latitude, double longitude) {
        // TODO: Implement weather data fetching logic here
        // Use latitude and longitude to fetch current weather information from a weather API
        // Update weatherTextView with the fetched weather data
        // Example:
        String weatherData = getWeatherDataFromAPI(latitude, longitude);
        weatherTextView.setText(weatherData);
    }

    private String getWeatherDataFromAPI(double latitude, double longitude) {
        // TODO: Call the weather API to get the weather data based on the latitude and longitude coordinates
        // Replace this placeholder code with actual code to fetch weather data from the weather API
        // Example:
        String apiKey = "41dbfb6383cd9ad8423c66aa93db866a";
        String apiUrl = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + latitude + "," + longitude;

        // Make an HTTP request to the weather API using a library like Retrofit, OkHttp, or Volley
        // Parse the response JSON to extract the relevant weather data (e.g., temperature, weather description)
        // Return the weather data as a formatted string

        return "Current Weather: Sunny";
    }

    private String getLocationName(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                return address.getLocality() + ", " + address.getAdminArea() + ", " + address.getCountryName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

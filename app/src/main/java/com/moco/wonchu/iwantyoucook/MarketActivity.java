package com.moco.wonchu.iwantyoucook;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import noman.googleplaces.PlacesListener;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.tasks.OnSuccessListener;


public class MarketActivity extends AppCompatActivity
        implements OnMapReadyCallback,
        OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks{

    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    boolean mLocationPermissionGranted;
    Location mLastKnownLocation;
    LatLng mCameraPosition;
    LatLng mDefaultLocation;
    float DEFAULT_ZOOM= 5;
    LatLngBounds.Builder builder= new LatLngBounds.Builder();

    private static final String TAG = "googlemap_market";
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100;
    //do setup activities

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        mGoogleApiClient= new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
                .build();
        mGoogleApiClient.connect();

        mFusedLocationClient= LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap map){
        mMap= map;
        //do setup activity
        updateLocationUI(); //turn on my location layer and the related control on the map.
        getDeviceLocation(); //get current location of the device and set the position of the map.
    }

    private void getDeviceLocation(){
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            mLocationPermissionGranted= true;
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }

        if(mLocationPermissionGranted){
            mLastKnownLocation= LocationServices.FusedLocationApi
                    .getLastLocation(mGoogleApiClient);
        }

        //set the map's camera position to the current location of the device.
        if(mCameraPosition !=null){
            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(),10));
        } else if (mLastKnownLocation != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(mLastKnownLocation.getLatitude(),
                            mLastKnownLocation.getLongitude()), DEFAULT_ZOOM
            ));
        }
        else{
            Log.d(TAG, "Current location is null, Using defaults: ");
            setDefaultLocation();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mDefaultLocation, DEFAULT_ZOOM));
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults){
        mLocationPermissionGranted= false;
        switch(requestCode){
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                //if request is cancelled, the result arrays are empty.
                if(grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    mLocationPermissionGranted=true;
                }
            }
        }
        updateLocationUI();
    }

    //builds the map when the google play services client is successfully connected.
    @Override
    public void onConnected(Bundle connectionHint){
        //now connected
        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onConnectionSuspended(int cause) {
        // We are not connected anymore!
        Log.d(TAG, "onConnectionSuspended");
        if (cause == CAUSE_NETWORK_LOST)
            Log.e(TAG, "onConnectionSuspended(): Google Play services " +
                    "connection lost.  Cause: network lost.");
        else if (cause == CAUSE_SERVICE_DISCONNECTED)
            Log.e(TAG, "onConnectionSuspended():  Google Play services " +
                    "connection lost.  Cause: service disconnected");
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // We tried to connect but failed!
        Log.d(TAG, "onConnectionFailed");
    }

    private void updateLocationUI(){
        if (mMap==null){
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                mLastKnownLocation = null;
                //getLocationPermission();
            }
        }
        catch (SecurityException e){
                Log.e("Exception: %s", e.getMessage());
            }
        }

        public void setDefaultLocation(){
            // set default location
           mDefaultLocation= new LatLng(37.566535, 126.977969); //Seoul
        }


        /* get last known location --> make a function!
         mFusedLocationClient.getLastLocation()
                 .addOnSuccessListener(this, new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {
            //got last known location. In some rare situations this can be null.
            if (location != null){
                //logic to handle location object
            }
        }
    }); */
}
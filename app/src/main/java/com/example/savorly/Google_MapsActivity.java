package com.example.savorly;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

public class Google_MapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap googleMap;
    //private Map<Marker, PlaceInfo> placeInfoMap = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.google_mapsactivity, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        googleMap = map;

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        /*hardcodePoints();

        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                View view = inflater.inflate(R.layout.map_windows, null);

                TextView titleTextView = view.findViewById(R.id.title);
                TextView hoursTextView = view.findViewById(R.id.hours);
                TextView websiteTextView = view.findViewById(R.id.website);

                PlaceInfo placeInfo = placeInfoMap.get(marker);
                if (placeInfo != null) {
                    titleTextView.setText(placeInfo.getName());
                    hoursTextView.setText("Hours: " + placeInfo.getHours());
                    websiteTextView.setText("Visit Website");
                }

                return view;
            }
        });

        googleMap.setOnInfoWindowClickListener(marker -> {
            PlaceInfo placeInfo = placeInfoMap.get(marker);
            if (placeInfo != null) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(placeInfo.getWebsite()));
                startActivity(browserIntent);
            }
        });
    }

    private void hardcodePoints() {
        LatLng trinityUniversity = new LatLng(29.463794, -98.481819);
        LatLng thePearl = new LatLng(29.44413, -98.47826);
        LatLng theAlamo = new LatLng(29.44149, -98.47926);

        PlaceInfo trinityInfo = new PlaceInfo("WTH", "https://www.trinity.edu/", "8AM - 5PM");
        PlaceInfo pearlInfo = new PlaceInfo("The Pearl", "https://atpearl.com/", "10AM - 9PM");
        PlaceInfo alamoInfo = new PlaceInfo("The Alamo", "https://www.thealamo.org/", "9AM - 5:30PM");

        Marker trinityMarker = googleMap.addMarker(new MarkerOptions().position(trinityUniversity).title(trinityInfo.getName()));
        placeInfoMap.put(trinityMarker, trinityInfo);

        Marker pearlMarker = googleMap.addMarker(new MarkerOptions().position(thePearl).title(pearlInfo.getName()));
        placeInfoMap.put(pearlMarker, pearlInfo);

        Marker alamoMarker = googleMap.addMarker(new MarkerOptions().position(theAlamo).title(alamoInfo.getName()));
        placeInfoMap.put(alamoMarker, alamoInfo);

        // Move the camera to a default location (e.g., the first marker)
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(trinityUniversity, 10);
        googleMap.moveCamera(cameraUpdate);
    }

    private static class PlaceInfo {
        private String name;
        private String website;
        private String hours;

        public PlaceInfo(String name, String website, String hours) {
            this.name = name;
            this.website = website;
            this.hours = hours;
        }

        public String getName() {
            return name;
        }

        public String getWebsite() {
            return website;
        }

        public String getHours() {
            return hours;
        }*/
    }
}
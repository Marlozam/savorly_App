package com.example.savorly.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.savorly.FilterRestaurants;
import com.example.savorly.R;
import com.example.savorly.Restaurant;
import com.example.savorly.RestaurantFilterOptions;
import com.example.savorly.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class HomeFragment extends Fragment implements OnMapReadyCallback {
    // part of the mainactivity binding coding class
    private FragmentHomeBinding binding;
    //part of setting up the map with ui
    private MapView mapView;
    private GoogleMap googleMap;

    //disclaimer chat-GPT helped me a bit with setting up the searchbar filter in ui
    private SearchView searchBar;
    private Spinner categorySpinner, distanceSpinner;
    private CheckBox glutenFreeCheck, vegetarianCheck;
    private Button filterButton;

    private List<Restaurant> restaurantList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize map
        mapView = root.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        // Initialize UI elements
        searchBar = root.findViewById(R.id.searchBar);
        categorySpinner = root.findViewById(R.id.categorySpinner);
        distanceSpinner = root.findViewById(R.id.distanceSpinner);
        glutenFreeCheck = root.findViewById(R.id.glutenFreeCheck);
        vegetarianCheck = root.findViewById(R.id.vegetarianCheck);
        filterButton = root.findViewById(R.id.filterButton);

        // Dummy data
        initializeRestaurants();

        filterButton.setOnClickListener(v -> applyFilter());

        return root;
    }

    private void initializeRestaurants() {
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Down on Grayson", "American", true, true, 1.5));
        restaurantList.add(new Restaurant("Best Quality Daughter", "Chinese", true, false, 2.0));
        restaurantList.add(new Restaurant("Bakery Lorraine", "French", true, true, 3.2));
        restaurantList.add(new Restaurant("Bird Bakery", "American", true, true, 1.0));
        // Add more as needed
    }

    private void applyFilter() {
        String query = searchBar.getQuery().toString().trim();

        String category = categorySpinner.getSelectedItem().toString();
        if (category.equals("All")) category = null;

        String distanceStr = distanceSpinner.getSelectedItem().toString();
        double maxDistance = Double.MAX_VALUE;
        if (distanceStr.contains("<")) {
            maxDistance = Double.parseDouble(distanceStr.replaceAll("[^\\d.]", ""));
        }

        boolean glutenFree = glutenFreeCheck.isChecked();
        boolean vegetarian = vegetarianCheck.isChecked();

        RestaurantFilterOptions options = new RestaurantFilterOptions(
                query.isEmpty() ? null : query,
                category,
                glutenFree,
                vegetarian,
                maxDistance
        );

        List<Restaurant> filtered = FilterRestaurants.filter(restaurantList, options);

        showRestaurantsOnMap(filtered);
    }

    private void showRestaurantsOnMap(List<Restaurant> restaurants) {
        if (googleMap == null) return;
        googleMap.clear();

        for (Restaurant r : restaurants) {
            // Dummy coordinates - in a real app, you'd want to store LatLng in Restaurant
            LatLng location = new LatLng(29.4600 + Math.random() * 0.02, -98.4800 + Math.random() * 0.02);
            googleMap.addMarker(new MarkerOptions().position(location).title(r.getrestaurantName()));
        }

        if (!restaurants.isEmpty()) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(29.463794, -98.481819), 12));
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(29.463794, -98.481819), 10));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
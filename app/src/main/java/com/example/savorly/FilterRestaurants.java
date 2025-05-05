package com.example.savorly;

import java.util.ArrayList;
import java.util.List;

public class FilterRestaurants {

    public static List<Restaurant> filter(List<Restaurant> restaurants, RestaurantFilterOptions options) {
        List<Restaurant> result = new ArrayList<>();

        for (Restaurant r : restaurants) {
            if (!options.query.isEmpty() && !r.getrestaurantName().toLowerCase().contains(options.query.toLowerCase())) {
                continue;
            }
            if (!options.category.equals("All") && !r.getfoodCategory().equalsIgnoreCase(options.category)) {
                continue;
            }
            if (options.glutenFree && !r.getisGlutenFree()) {
                continue;
            }
            if (options.vegetarian && !r.getisVegitarian()) {
                continue;
            }
            if (r.getdistFromRest() > options.maxDistance) {
                continue;
            }
            result.add(r);
        }

        return result;
    }

}

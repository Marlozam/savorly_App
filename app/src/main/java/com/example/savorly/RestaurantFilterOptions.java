package com.example.savorly;

public class RestaurantFilterOptions {
    public String query;
    public String category;
    public boolean glutenFree;
    public boolean vegetarian;
    public double maxDistance;

    public RestaurantFilterOptions(String query, String category, boolean glutenFree, boolean vegetarian, double maxDistance) {
        this.query = query;
        this.category = category;
        this.glutenFree = glutenFree;
        this.vegetarian = vegetarian;
        this.maxDistance = maxDistance;
    }
}

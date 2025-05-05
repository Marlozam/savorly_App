package com.example.savorly;

public class Restaurant {
    String restaurantName;
    String foodCategory;
    boolean isGlutenFree;
    boolean isVegitarian;
    double distFromRest;

    public Restaurant(String restaurantName, String foodcategory, boolean isGlutenFree, boolean isVegitarian, double distFromRest) {
        this.restaurantName = restaurantName;
        this.foodCategory = foodCategory;
        this.isGlutenFree = isGlutenFree;
        this.isVegitarian = isVegitarian;
        this.distFromRest = distFromRest;
    }

    //now I need to get all my variables for each restraunt
    public String getrestaurantName() {
        return restaurantName;
    }
    public String getfoodCategory() {
        return foodCategory;
    }
    public boolean getisGlutenFree() {
        return isGlutenFree;
    }
    public boolean getisVegitarian() {
        return isVegitarian;
    }
    public double getdistFromRest() {
        return distFromRest;
    }
}

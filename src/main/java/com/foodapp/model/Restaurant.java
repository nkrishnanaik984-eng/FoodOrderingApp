package com.foodapp.model;

/*
 * Restaurant Model Class
 * This class represents one record of Restaurant table.
 */

public class Restaurant {

    private int restaurantId;
    private String restaurantName;
    private String address;
    private String phone;
    private double rating;

    // Default Constructor
    public Restaurant() {

    }

    // Parameterized Constructor
    public Restaurant(int restaurantId, String restaurantName,
            String address, String phone, double rating) {

        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
    }

    // Getter and Setter

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId
                + ", restaurantName=" + restaurantName
                + ", address=" + address
                + ", phone=" + phone
                + ", rating=" + rating + "]";
    }

}
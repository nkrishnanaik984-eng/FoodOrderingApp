package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Restaurant;

/*
 * RestaurantDAO Interface
 *
 * This interface contains all the database
 * operations related to the Restaurant table.
 */

public interface RestaurantDAO {

    /*
     * Add a new restaurant
     */
    boolean addRestaurant(Restaurant restaurant);

    /*
     * Get restaurant using restaurant id
     */
    Restaurant getRestaurantById(int restaurantId);

    /*
     * Get all restaurants
     */
    List<Restaurant> getAllRestaurants();

    /*
     * Update restaurant details
     */
    boolean updateRestaurant(Restaurant restaurant);

    /*
     * Delete restaurant
     */
    boolean deleteRestaurant(int restaurantId);

}
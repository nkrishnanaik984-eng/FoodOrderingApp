package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.dbutil.DButil;
import com.foodapp.model.Restaurant;

/*
 * RestaurantDAOImpl
 * This class implements all the CRUD methods
 * of RestaurantDAO interface.
 */

public class RestaurantDAOImpl implements RestaurantDAO {

    // Database Connection
    private Connection connection;

    // Constructor
    public RestaurantDAOImpl() {

        connection = DButil.getConnection();
    }

    // ==========================
    // Add Restaurant
    // ==========================
    @Override
    public boolean addRestaurant(Restaurant restaurant) {

        String query = "INSERT INTO restaurant(restaurant_name,address,phone,rating) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getAddress());
            ps.setString(3, restaurant.getPhone());
            ps.setDouble(4, restaurant.getRating());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // Get Restaurant By Id
    // ==========================
    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        Restaurant restaurant = null;

        String query = "SELECT * FROM restaurant WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setRating(rs.getDouble("rating"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return restaurant;
    }

    // ==========================
    // Get All Restaurants
    // ==========================
    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> restaurantList = new ArrayList<>();

        String query = "SELECT * FROM restaurant";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setRating(rs.getDouble("rating"));

                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return restaurantList;
    }

    // ==========================
    // Update Restaurant
    // ==========================
    @Override
    public boolean updateRestaurant(Restaurant restaurant) {

        String query = "UPDATE restaurant SET restaurant_name=?, address=?, phone=?, rating=? WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getAddress());
            ps.setString(3, restaurant.getPhone());
            ps.setDouble(4, restaurant.getRating());
            ps.setInt(5, restaurant.getRestaurantId());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // Delete Restaurant
    // ==========================
    @Override
    public boolean deleteRestaurant(int restaurantId) {

        String query = "DELETE FROM restaurant WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, restaurantId);

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

}
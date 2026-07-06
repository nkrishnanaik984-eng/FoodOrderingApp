package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.MenuDAO;
import com.foodapp.dbutil.DButil;
import com.foodapp.model.Menu;

/*
 * MenuDAOImpl
 * This class implements all the CRUD methods
 * of the MenuDAO interface.
 */

public class MenuDAOImpl implements MenuDAO {

    // Database Connection
    private Connection connection;

    // Constructor
    public MenuDAOImpl() {
        connection = DButil.getConnection();
    }

    /*
     * Add Menu Item
     */
    @Override
    public boolean addMenu(Menu menu) {

        String query = "INSERT INTO menu(restaurant_id, item_name, description, price, availability) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getAvailability());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    /*
     * Get Menu By ID
     */
    @Override
    public Menu getMenuById(int menuId) {

        Menu menu = null;

        String query = "SELECT * FROM menu WHERE menu_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menuId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailability(rs.getString("availability"));
                menu.setImageUrl(rs.getString("image_url"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return menu;
    }

    /*
     * Get All Menu Items
     */
    @Override
    public List<Menu> getAllMenus() {

        List<Menu> menuList = new ArrayList<>();

        String query = "SELECT * FROM menu";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailability(rs.getString("availability"));
                menu.setImageUrl(rs.getString("image_url"));

                menuList.add(menu);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return menuList;
    }

    /*
     * Get Menu Items By Restaurant ID
     */
    @Override
    public List<Menu> getMenuByRestaurant(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        String query = "SELECT * FROM menu WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailability(rs.getString("availability"));
                menu.setImageUrl(rs.getString("image_url"));

                menuList.add(menu);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return menuList;
    }

    /*
     * Update Menu Item
     */
    @Override
    public boolean updateMenu(Menu menu) {

        String query = "UPDATE menu SET restaurant_id=?, item_name=?, description=?, price=?, availability=? WHERE menu_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getAvailability());
            ps.setInt(6, menu.getMenuId());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    /*
     * Delete Menu Item
     */
    @Override
    public boolean deleteMenu(int menuId) {

        String query = "DELETE FROM menu WHERE menu_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menuId);

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
}
package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Menu;

/*
 * MenuDAO Interface
 *
 * This interface contains all the database
 * operations related to the Menu table.
 */

public interface MenuDAO {

    /*
     * Add a new menu item
     */
    boolean addMenu(Menu menu);

    /*
     * Get menu item using menu id
     */
    Menu getMenuById(int menuId);

    /*
     * Get all menu items
     */
    List<Menu> getAllMenus();

    /*
     * Get all menu items of a particular restaurant
     */
    List<Menu> getMenuByRestaurant(int restaurantId);

    /*
     * Update menu item
     */
    boolean updateMenu(Menu menu);

    /*
     * Delete menu item
     */
    boolean deleteMenu(int menuId);

}
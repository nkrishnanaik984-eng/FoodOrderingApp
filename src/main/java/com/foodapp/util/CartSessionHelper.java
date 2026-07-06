package com.foodapp.util;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.OrderItem;

/*
 * CartSessionHelper
 *
 * Simple helper class to manage cart items
 * stored in the HTTP session before checkout.
 */

public class CartSessionHelper {

    private List<OrderItem> cartItems;
    private int restaurantId;

    public CartSessionHelper() {
        cartItems = new ArrayList<>();
        restaurantId = 0;
    }

    public List<OrderItem> getCartItems() {
        return cartItems;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    /*
     * Add item to cart.
     * If the item already exists, increase its quantity instead
     * of adding a duplicate row.
     */
    public void addItem(OrderItem newItem) {

        for (OrderItem item : cartItems) {

            if (item.getMenuId() == newItem.getMenuId()) {

                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                item.setSubtotal(item.getPrice() * item.getQuantity());
                return;
            }
        }

        cartItems.add(newItem);
    }

    public void removeItem(int menuId) {

        cartItems.removeIf(item -> item.getMenuId() == menuId);
    }

    public double getTotalAmount() {

        double total = 0;

        for (OrderItem item : cartItems) {
            total += item.getSubtotal();
        }

        return total;
    }

    public void clearCart() {
        cartItems.clear();
        restaurantId = 0;
    }
}
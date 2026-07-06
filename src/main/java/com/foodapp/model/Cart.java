package com.foodapp.model;

public class Cart {

    private int cartId;
    private int userId;
    private int menuId;
    private int restaurantId;
    private int quantity;

    // Extra fields for display (filled via JOIN with menu table)
    private String itemName;
    private double price;

    public Cart() {

    }

    public Cart(int cartId, int userId, int menuId, int restaurantId, int quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId
                + ", userId=" + userId
                + ", menuId=" + menuId
                + ", restaurantId=" + restaurantId
                + ", quantity=" + quantity + "]";
    }
}
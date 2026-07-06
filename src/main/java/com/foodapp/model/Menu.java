package com.foodapp.model;

/*
 * Menu Model Class
 * This class represents one record of the Menu table.
 */

public class Menu {

    private int menuId;
    private int restaurantId;
    private String itemName;
    private String description;
    private double price;
    private String availability;
    private String imageUrl;

    // Default Constructor
    public Menu() {

    }

    // Parameterized Constructor
    public Menu(int menuId, int restaurantId, String itemName,
            String description, double price, String availability,
            String imageUrl) {

        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.imageUrl = imageUrl;
    }

    // Getter and Setter

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {

        return "Menu [menuId=" + menuId
                + ", restaurantId=" + restaurantId
                + ", itemName=" + itemName
                + ", description=" + description
                + ", price=" + price
                + ", availability=" + availability
                + ", imageUrl=" + imageUrl + "]";
    }

}
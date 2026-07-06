package com.foodapp.model;

/*
 * User POJO (Plain Old Java Object)
 * This class represents one record from the User table.
 */

public class User {

    // Instance Variables (Fields)

    private int userId;
    private String name;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;

    // Default Constructor
    public User() {

    }

    // Parameterized Constructor
    public User(int userId, String name, String username, String email,
            String password, String phone, String address, String role) {

        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    // Getter for userId
    public int getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }

    // toString() Method
    @Override
    public String toString() {
        return "User [userId=" + userId +
                ", name=" + name +
                ", username=" + username +
                ", email=" + email +
                ", password=" + password +
                ", phone=" + phone +
                ", address=" + address +
                ", role=" + role + "]";
    }
}
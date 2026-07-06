package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;
import com.foodapp.dbutil.DButil;

/*
 * UserDAOImpl Class
 *
 * This class implements all the methods
 * declared in the UserDAO interface.
 */

public class UserDAOImpl implements UserDAO {

    // Create Connection Object
    private Connection connection;

    // Constructor
    public UserDAOImpl() {

        // Get database connection
        connection = DButil.getConnection();
    }

    /*
     * Add New User
     */
    @Override
    public boolean addUser(User user) {

        String query = "INSERT INTO user(name, username, email, password, phone, address, role) VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getRole());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /*
     * Get User By ID
     */
    @Override
    public User getUserById(int userId) {

        User user = null;

        String query = "SELECT * FROM user WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /*
     * Get User By Username
     */
    @Override
    public User getUserByUsername(String username) {

        User user = null;

        String query = "SELECT * FROM user WHERE username=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /*
     * Get All Users
     */
    @Override
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        String query = "SELECT * FROM user";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    /*
     * Update User
     */
    @Override
    public boolean updateUser(User user) {

        String query = "UPDATE user SET name=?, username=?, email=?, password=?, phone=?, address=?, role=? WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getRole());
            ps.setInt(8, user.getUserId());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /*
     * Delete User
     */
    @Override
    public boolean deleteUser(int userId) {

        String query = "DELETE FROM user WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, userId);

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /*
     * Login User
     */
    @Override
    public User loginUser(String username, String password) {

        User user = null;

        String query = "SELECT * FROM user WHERE username=? AND password=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
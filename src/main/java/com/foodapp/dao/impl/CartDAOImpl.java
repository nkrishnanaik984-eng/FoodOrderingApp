package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.CartDAO;
import com.foodapp.dbutil.DButil;
import com.foodapp.model.Cart;

public class CartDAOImpl implements CartDAO {

    // Removed the global instance variable to ensure fresh connections
    public CartDAOImpl() {
    }

    @Override
    public boolean addToCart(Cart cart) {
        String query = "INSERT INTO cart(user_id, menu_id, restaurant_id, quantity) VALUES(?,?,?,?)";
        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getMenuId());
            ps.setInt(3, cart.getRestaurantId());
            ps.setInt(4, cart.getQuantity());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cart getCartItemByUserAndMenu(int userId, int menuId) {
        Cart cart = null;
        String query = "SELECT * FROM cart WHERE user_id=? AND menu_id=?";
        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, userId);
            ps.setInt(2, menuId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cart = new Cart();
                    cart.setCartId(rs.getInt("cart_id"));
                    cart.setUserId(rs.getInt("user_id"));
                    cart.setMenuId(rs.getInt("menu_id"));
                    cart.setRestaurantId(rs.getInt("restaurant_id"));
                    cart.setQuantity(rs.getInt("quantity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public List<Cart> getCartByUser(int userId) {
        List<Cart> cartList = new ArrayList<>();
        String query = "SELECT c.cart_id, c.user_id, c.menu_id, c.restaurant_id, c.quantity, "
                + "m.item_name, m.price "
                + "FROM cart c "
                + "JOIN menu m ON c.menu_id = m.menu_id "
                + "WHERE c.user_id = ?";

        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cart cart = new Cart();
                    cart.setCartId(rs.getInt("cart_id"));
                    cart.setUserId(rs.getInt("user_id"));
                    cart.setMenuId(rs.getInt("menu_id"));
                    cart.setRestaurantId(rs.getInt("restaurant_id"));
                    cart.setQuantity(rs.getInt("quantity"));
                    cart.setItemName(rs.getString("item_name"));
                    cart.setPrice(rs.getDouble("price"));
                    cartList.add(cart);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public boolean updateQuantity(int cartId, int quantity) {
        String query = "UPDATE cart SET quantity=? WHERE cart_id=?";
        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, quantity);
            ps.setInt(2, cartId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeCartItem(int cartId) {
        String query = "DELETE FROM cart WHERE cart_id=?";
        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, cartId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clearCart(int userId) {
        String query = "DELETE FROM cart WHERE user_id=?";
        try (Connection connection = DButil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
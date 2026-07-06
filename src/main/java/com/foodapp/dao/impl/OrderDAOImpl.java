package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.OrderDAO;
import com.foodapp.dbutil.DButil;
import com.foodapp.model.OrderItem;
import com.foodapp.model.Orders;

public class OrderDAOImpl implements OrderDAO {

    private Connection connection;

    public OrderDAOImpl() {
        connection = DButil.getConnection();
    }

    /*
     * Insert a new order into the 'orders' table and return the generated auto-increment order_id
     */
    @Override
    public int placeOrder(Orders order) {

        int generatedOrderId = -1;
        // Wrapped table name in backticks to guarantee compatibility with SQL reserved keywords
        String query = "INSERT INTO `orders` (user_id, total_amount, order_date, status) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setTimestamp(3, order.getOrderDate());
            ps.setString(4, order.getStatus());

            int result = ps.executeUpdate();

            if (result > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    generatedOrderId = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedOrderId;
    }

    /*
     * Insert an individual transaction item mapping back to a specific parent order ID
     */
    @Override
    public boolean addOrderItem(OrderItem item) {

        String query = "INSERT INTO `order_item` (order_id, menu_id, quantity, subtotal) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getMenuId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getSubtotal());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /*
     * Get all past order history records belonging to a unique user profile
     */
    @Override
    public List<Orders> getOrdersByUser(int userId) {

        List<Orders> orderList = new ArrayList<>();
        String query = "SELECT * FROM `orders` WHERE user_id = ? ORDER BY order_date DESC";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Orders order = new Orders();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderDate(rs.getTimestamp("order_date"));
                order.setStatus(rs.getString("status"));

                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    /*
     * Get all discrete items associated with an order ID, joined with the menu table to retrieve clear descriptions
     */
    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> itemList = new ArrayList<>();
        String query = "SELECT oi.order_item_id, oi.order_id, oi.menu_id, oi.quantity, oi.subtotal, "
                + "m.item_name "
                + "FROM `order_item` oi "
                + "JOIN `menu` m ON oi.menu_id = m.menu_id "
                + "WHERE oi.order_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setMenuId(rs.getInt("menu_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setItemName(rs.getString("item_name"));

                itemList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
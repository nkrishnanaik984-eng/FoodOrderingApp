package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Orders;
import com.foodapp.model.OrderItem;

public interface OrderDAO {

    int placeOrder(Orders order);

    boolean addOrderItem(OrderItem item);

    List<Orders> getOrdersByUser(int userId);

    List<OrderItem> getOrderItemsByOrderId(int orderId);
}
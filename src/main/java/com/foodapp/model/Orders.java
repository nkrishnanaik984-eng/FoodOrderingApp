package com.foodapp.model;

import java.sql.Timestamp;

public class Orders {

    private int orderId;
    private int userId;
    private double totalAmount;
    private Timestamp orderDate;
    private String status;

    public Orders() {

    }

    public Orders(int orderId, int userId, double totalAmount,
            Timestamp orderDate, String status) {

        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders [orderId=" + orderId
                + ", userId=" + userId
                + ", totalAmount=" + totalAmount
                + ", orderDate=" + orderDate
                + ", status=" + status + "]";
    }
}
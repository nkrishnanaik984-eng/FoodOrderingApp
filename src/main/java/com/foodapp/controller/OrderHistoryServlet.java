package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.OrderDAO;
import com.foodapp.dao.impl.OrderDAOImpl;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Orders> orderList = orderDAO.getOrdersByUser(user.getUserId());

        request.setAttribute("orderList", orderList);

        request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
    }
}
package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.CartDAO;
import com.foodapp.dao.impl.CartDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    CartDAO cartDAO = new CartDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        cartDAO.updateQuantity(cartId, quantity);

        response.sendRedirect("viewCart");    }
}
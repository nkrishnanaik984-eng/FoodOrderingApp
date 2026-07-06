package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.CartDAO;
import com.foodapp.dao.impl.CartDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO = new CartDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 1. Session Guard Clause: Ensure user is authenticated
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getUserId();

        // 2. Data Retrieval: Pull active items from database layer
        List<Cart> cartList = cartDAO.getCartByUser(userId);

        // FALLBACK: Look into active session memory if DB returns empty
        if (cartList == null || cartList.isEmpty()) {
            @SuppressWarnings("unchecked")
            List<Cart> sessionCart = (List<Cart>) session.getAttribute("cartList");
            cartList = sessionCart;
        }

        // 3. Validation Check: Redirect back to cart if completely empty
        if (cartList == null || cartList.isEmpty()) {
            response.sendRedirect("viewCart");
            return;
        }

        // 4. Core Business Logic: Calculate bill valuation
        double totalAmount = 0;
        for (Cart item : cartList) {
            totalAmount += (item.getPrice() * item.getQuantity());
        }

        // 5. Context Binding: Set attribute for request scope consumption
        request.setAttribute("totalAmount", totalAmount);
        
        // 6. Navigation: Internally dispatch context execution to checkout template
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Uniform routing design handles form submissions seamlessly
        doGet(request, response);
    }
}
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

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    CartDAO cartDAO = new CartDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int menuId = Integer.parseInt(request.getParameter("menuId"));
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        int userId = user.getUserId();

        // Check if item already exists in cart for this user
        Cart existingItem = cartDAO.getCartItemByUserAndMenu(userId, menuId);

        if (existingItem != null) {
            // Item already in cart, just increase quantity
            int newQty = existingItem.getQuantity() + quantity;
            cartDAO.updateQuantity(existingItem.getCartId(), newQty);
        } else {
            // New item, insert into cart
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setMenuId(menuId);
            cart.setRestaurantId(restaurantId);
            cart.setQuantity(quantity);

            // Fetch the item price from request if your frontend sends it, 
            // or let the DAO/DB layer handle it.
            if(request.getParameter("price") != null) {
                cart.setPrice(Double.parseDouble(request.getParameter("price")));
            }
            if(request.getParameter("itemName") != null) {
                cart.setItemName(request.getParameter("itemName"));
            }

            cartDAO.addToCart(cart);
        }

        // ==========================================
        // FIX: SYNC THE DATABASE ITEMS TO THE SESSION
        // ==========================================
        List<Cart> updatedCartList = cartDAO.getCartByUser(userId);
        session.setAttribute("cartList", updatedCartList);
        // ==========================================

        response.sendRedirect("viewCart");
    }
}
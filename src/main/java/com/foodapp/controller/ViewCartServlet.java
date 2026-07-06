package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.CartDAO;
import com.foodapp.dao.impl.CartDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    CartDAO cartDAO = new CartDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Cart> cartList = cartDAO.getCartByUser(user.getUserId());

        request.setAttribute("cartList", cartList);

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
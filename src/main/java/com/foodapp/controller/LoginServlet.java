package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.UserDAO;
import com.foodapp.dao.impl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * LoginServlet
 * This servlet handles user login
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get login form data
        String USERNAME = request.getParameter("username");
        String PASSWORD= request.getParameter("password");

        // 2. Validate user from DB
        User user = userDAO.loginUser(USERNAME, PASSWORD);

        // 3. If user exists → login success
        if (user != null) {

            // create session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // redirect to home page
            response.sendRedirect("restaurants");
        } else {
            // login failed
            response.sendRedirect("login.jsp");
        }
    }
}
package com.foodapp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * LogoutServlet
 * This servlet destroys the session and logs out the user
 */

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get current session (if exists)
        HttpSession session = request.getSession(false);

        // 2. If session exists, destroy it
        if (session != null) {
            session.invalidate();
        }

        // 3. Redirect to login page
        response.sendRedirect("login.jsp");
    }
}
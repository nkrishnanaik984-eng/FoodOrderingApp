package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.MenuDAO;
import com.foodapp.dao.impl.MenuDAOImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    MenuDAO menuDAO = new MenuDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

        List<Menu> menuList = menuDAO.getMenuByRestaurant(restaurantId);

        request.setAttribute("menuList", menuList);
        request.setAttribute("restaurantId", restaurantId);

        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}
package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.dao.impl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurants")
public class RestaurantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RestaurantDAO dao = new RestaurantDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Restaurant> restaurantList = dao.getAllRestaurants();

		request.setAttribute("restaurantList", restaurantList);

		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

}
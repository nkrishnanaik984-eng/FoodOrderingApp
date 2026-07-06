package com.foodapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	// Database URL
	private static final String URL = "jdbc:mysql://localhost:3306/food_ordering_db";

	// Database Username
	private static final String USERNAME = "root";

	// Database Password
	private static final String PASSWORD = "Jasmita@12345678";

	// Method to return database connection
	public static Connection getConnection() {

		Connection con = null;

		try {

			// Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			System.out.println("Database Connected Successfully");

		} catch (ClassNotFoundException e) {

			System.out.println("Driver Not Found");
			e.printStackTrace();

		} catch (SQLException e) {

			System.out.println("Database Connection Failed");
			e.printStackTrace();
		}

		return con;
	}

}
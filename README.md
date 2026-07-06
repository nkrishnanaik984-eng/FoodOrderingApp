 🍔 Food Ordering App

A Java-based Food Ordering Web Application developed using JSP, Servlets, JDBC, MySQL, and Apache Tomcat in Eclipse IDE. The application allows users to browse restaurants, view menus, add food items to a shopping cart, and place orders through a simple and responsive web interface.

---

📌 Features

- 👤 User Registration and Login
- 🍽️ Browse Restaurants
- 📋 View Restaurant Menus
- 🛒 Add Items to Cart
- ➕ Update Item Quantity
- ❌ Remove Items from Cart
- 💰 Order Summary
- 📦 Place Orders
- 💾 MySQL Database Integration
- 🎨 Responsive User Interface

---

🛠️ Technology Stack

Frontend

- HTML5
- CSS3
- JavaScript
- JSP

Backend

- Java
- Servlets
- JDBC

Database

- MySQL

Server

- Apache Tomcat 10

IDE

- Eclipse IDE for Enterprise Java and Web Developers

---

📁 Project Structure

FoodOrderingApp/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── controller/
│       │   ├── dao/
│       │   ├── model/
│       │   └── util/
│       │
│       └── webapp/
│           ├── css/
│           ├── images/
│           ├── js/
│           ├── WEB-INF/
│           ├── index.jsp
│           ├── login.jsp
│           ├── register.jsp
│           ├── restaurants.jsp
│           ├── menu.jsp
│           ├── cart.jsp
│           └── orderSuccess.jsp
│
└── README.md

---

⚙️ Software Requirements

- Java JDK 17
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 10
- MySQL Server 8.0+
- MySQL Connector/J

---

🚀 Setup Instructions

1. Clone the Repository

git clone https://github.com/nkrishnanaik984-eng/FoodOrderingApp.git

2. Import into Eclipse

- Open Eclipse.
- Go to File → Import.
- Select Existing Projects into Workspace.
- Browse to the cloned project folder.
- Click Finish.

3. Configure Apache Tomcat

- Open the Servers view.
- Add Apache Tomcat 10.
- Right-click the server and choose Add and Remove....
- Add the FoodOrderingApp project.

4. Configure MySQL

- Create a database named:

food_delivery_db

- Execute the SQL script provided in the project to create all required tables.

5. Update Database Configuration

Modify the database connection details in the JDBC utility class.

Example:

String url = "jdbc:mysql://localhost:3306/food_delivery_db";
String username = "root";
String password = "your_password";

6. Run the Project

- Start the Tomcat server.
- Open your browser and visit:

http://localhost:8080/FoodOrderingApp/

---

📸 Application Pages

- Home Page
- Login
- Registration
- Restaurant List
- Menu Page
- Shopping Cart
- Order Confirmation

---

🔮 Future Improvements

- Online Payment Integration
- Order Tracking
- Admin Dashboard
- Restaurant Management
- User Profile Management
- Ratings and Reviews
- Email Notifications

---

👨‍💻 Author

Jasmita Krishna Naik

GitHub: https://github.com/nkrishnanaik984-eng

---

📄 License

This project is developed for learning and educational purposes.

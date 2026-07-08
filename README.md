# 🍔 Food Ordering Application

A **Java-based Full-Stack Food Ordering Web Application** built using **JSP, Servlets, JDBC, MySQL, and Apache Tomcat** following the **MVC Architecture** and **DAO Design Pattern**.

This project enables users to browse restaurants, explore menus, add food items to a shopping cart, and place orders through a simple, responsive, and user-friendly interface. It was developed to gain hands-on experience with core Java Enterprise technologies without relying on frameworks.

---

## 📖 Project Overview

The Food Ordering Application simulates an online food delivery platform where customers can:

* Create an account and log in securely
* Browse multiple restaurants
* View restaurant-specific menus
* Add food items to a shopping cart
* Update or remove cart items
* Place food orders
* View order confirmation

The application uses **JDBC** for database connectivity and **MySQL** for data storage while following the **MVC design pattern** for better code organization and maintainability.

---

# ✨ Features

* 👤 User Registration
* 🔐 Secure User Login
* 🍽 Browse Restaurants
* 📋 Dynamic Restaurant Menus
* 🛒 Shopping Cart
* ➕ Update Item Quantity
* ❌ Remove Items from Cart
* 💰 Order Summary
* 📦 Order Placement
* 💾 MySQL Database Integration
* 🔄 Session Management
* 🎨 Responsive User Interface
* 🏗 MVC Architecture
* 📂 DAO Design Pattern

---

# 🛠 Tech Stack

## Frontend

* HTML5
* CSS3
* JavaScript
* JSP

## Backend

* Java 17
* Jakarta Servlets
* JDBC

## Database

* MySQL 8.0

## Server

* Apache Tomcat 10.1

## Build Tool

* Maven

## IDE

* Eclipse IDE for Enterprise Java and Web Developers

---

# 📂 Project Structure

```text
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
├── pom.xml
└── README.md
```

---

# ⚙ Software Requirements

* Java JDK 17
* Eclipse IDE for Enterprise Java and Web Developers
* Apache Tomcat 10.1
* MySQL Server 8.0+
* MySQL Connector/J
* Maven

---

# 🚀 Installation & Setup

## 1. Clone the Repository

```bash
git clone https://github.com/nkrishnanaik984-eng/FoodOrderingApp.git
```

---

## 2. Import the Project into Eclipse

* Open Eclipse IDE
* Go to **File → Import**
* Select **Existing Maven Projects**
* Browse to the cloned repository
* Click **Finish**

---

## 3. Configure Apache Tomcat

* Open the **Servers** view
* Add **Apache Tomcat 10.1**
* Right-click the server
* Select **Add and Remove**
* Add the **FoodOrderingApp** project
* Save the configuration

---

## 4. Configure MySQL Database

Create a database named:

```sql
food_delivery_db
```

Execute the SQL script included in the project to create all required tables.

---

## 5. Update Database Configuration

Modify the JDBC configuration in your utility class.

```java
String url = "jdbc:mysql://localhost:3306/food_delivery_db";
String username = "root";
String password = "your_password";
```

---

## 6. Run the Application

Start Apache Tomcat and open:

```text
http://localhost:8080/FoodOrderingApp/
```

---

# 📸 Application Screens

* 🏠 Home Page
* 🔐 Login
* 📝 Registration
* 🍽 Restaurant Listing
* 📋 Restaurant Menu
* 🛒 Shopping Cart
* 💰 Checkout
* 📦 Order Confirmation

---

# 📚 Learning Outcomes

This project helped me understand:

* Java Web Development
* JSP & Servlets
* MVC Architecture
* DAO Design Pattern
* JDBC Database Connectivity
* Session Management
* SQL Queries
* CRUD Operations
* Apache Tomcat Deployment
* Maven Project Structure
* Responsive Web Design

---

# 🚀 Future Enhancements

* 💳 Online Payment Gateway
* 📍 Live Order Tracking
* 👨‍💼 Admin Dashboard
* 🍴 Restaurant Management
* ⭐ Ratings & Reviews
* 👤 User Profile Management
* 📧 Email Notifications
* 🔍 Search & Filters
* ❤️ Wishlist / Favorites

---

# 👨‍💻 Author

**Jasmita Krishna Naik**

GitHub: https://github.com/nkrishnanaik984-eng

---

# 🤝 Contributions

Contributions, suggestions, and improvements are always welcome.

Feel free to fork this repository, open issues, or submit pull requests.

---

# 📄 License

This project is developed for educational and learning purposes.

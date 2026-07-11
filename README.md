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
  <img width="1921" height="912" alt="Screenshot 2026-07-11 162205" src="https://github.com/user-attachments/assets/72701b46-e0ca-4005-b1b8-1f39a528388e" />
  <img width="1900" height="910" alt="Screenshot 2026-07-11 162232" src="https://github.com/user-attachments/assets/f9846ae4-2d0c-42d1-b1a3-3c9a9b4f2503" />
  <img width="1909" height="915" alt="Screenshot 2026-07-11 162506" src="https://github.com/user-attachments/assets/a273d432-899b-42f3-b698-4fd78aa2fd48" />
  <img width="1895" height="916" alt="Screenshot 2026-07-11 162535" src="https://github.com/user-attachments/assets/73cf50a6-1742-4062-a4e2-b17e3ff7774d" />
  <img width="1922" height="914" alt="Screenshot 2026-07-11 162613" src="https://github.com/user-attachments/assets/28789921-5458-4793-b5c1-85e3c482bf0b" />
<img width="1921" height="915" alt="Screenshot 2026-07-11 162639" src="https://github.com/user-attachments/assets/768017f1-08e8-4b1a-be13-8c68e4bb61d2" />
<img width="1921" height="910" alt="Screenshot 2026-07-11 162655" src="https://github.com/user-attachments/assets/1734aa69-160f-4510-8740-c85cf64517e1" />


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

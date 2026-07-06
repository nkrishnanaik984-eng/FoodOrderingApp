<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.foodapp.model.User"%>
<%@ page import="com.foodapp.model.Restaurant"%>
<%@ page import="java.util.List"%>

<%
	// Check whether user is logged in
	User user = (User) session.getAttribute("user");

	if (user == null) {
		response.sendRedirect("login.jsp");
		return;
	}

	// Get restaurant list from RestaurantServlet

@SuppressWarnings("unchecked")
List<Restaurant> restaurantList =
        (List<Restaurant>) request.getAttribute("restaurantList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Ordering Application</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:'Segoe UI', Arial, Helvetica, sans-serif;
}

body{
	background:#faf7f2;
}

/* Header */

.header{

	background:linear-gradient(135deg, #ff6b35, #ff3d00);
	color:white;
	padding:22px 40px;
	display:flex;
	justify-content:space-between;
	align-items:center;
	box-shadow:0 4px 20px rgba(255, 61, 0, 0.3);
	position:sticky;
	top:0;
	z-index:100;
}

.header h1{

	font-size:30px;
	font-weight:800;
	letter-spacing:0.5px;
}

.user-info{

	text-align:right;
	display:flex;
	align-items:center;
	gap:18px;
}

.user-info .greeting p{

	margin:0;
	font-size:13px;
	opacity:0.9;
}

.user-info .greeting b{

	font-size:16px;
}

.logout{

	color:white;
	text-decoration:none;
	font-weight:700;
	font-size:14px;
	padding:8px 16px;
	border:2px solid rgba(255,255,255,0.6);
	border-radius:20px;
	transition:0.25s;
}

.logout:hover{

	background:white;
	color:#ff3d00;
	border-color:white;
}

/* Page heading */

.section-title{

	max-width:1200px;
	margin:35px auto 20px auto;
	padding:0 20px;
}

.section-title h2{

	font-size:24px;
	color:#2d2d2d;
	font-weight:800;
}

.section-title p{

	color:#888;
	margin-top:4px;
	font-size:14px;
}

/* Restaurant Container */

.restaurant-container{

	max-width:1200px;
	margin:0 auto 50px auto;
	padding:0 20px;

	display:grid;
	grid-template-columns:repeat(auto-fill, minmax(280px, 1fr));
	gap:24px;
}

/* Restaurant Card */

.card{

	background:white;

	border-radius:16px;

	box-shadow:0 4px 15px rgba(0,0,0,0.08);

	padding:24px;

	transition:0.3s ease;

	position:relative;

	border:1px solid #f0e9e0;
}

.card:hover{

	transform:translateY(-6px);
	box-shadow:0 14px 30px rgba(255, 107, 53, 0.2);
}

.card h2{

	color:#2d2d2d;
	margin-bottom:14px;
	font-size:20px;
	font-weight:800;
}

.card p{

	margin:8px 0;
	color:#666;
	font-size:14px;
}

.card p b{

	color:#333;
}

.rating-badge{

	display:inline-flex;
	align-items:center;
	gap:5px;
	background:#e8f8ee;
	color:#1e7e34;
	font-weight:800;
	padding:4px 10px;
	border-radius:8px;
	font-size:14px;
	margin:10px 0;
}

button{

	width:100%;

	padding:12px;

	background:linear-gradient(135deg, #28a745, #1e7e34);

	color:white;

	border:none;

	border-radius:25px;

	cursor:pointer;

	margin-top:15px;

	font-weight:700;
	font-size:15px;
	letter-spacing:0.3px;

	transition:0.25s;
}

button:hover{

	background:linear-gradient(135deg, #1e7e34, #175e28);
	box-shadow:0 6px 14px rgba(40, 167, 69, 0.4);
	transform:translateY(-2px);
}

.no-data{

	text-align:center;

	font-size:22px;

	color:#ff3d00;

	margin-top:60px;

	grid-column:1/-1;
}

</style>

</head>

<body>

<!-- Header -->

<div class="header">

	<div>

		<h1>🍽️ Food Ordering Application</h1>

	</div>

	<div class="user-info">

		<div class="greeting">
			<p>Welcome back,</p>
			<b><%=user.getName()%></b>
		</div>

 <a class="logout" href="orderHistory">My Orders</a>
<a class="logout" href="logout">Logout</a>
	</div>

</div>

<!-- Section title -->

<div class="section-title">
	<h2>Restaurants near you</h2>
	<p>Choose from the best places to order food</p>
</div>

<!-- Restaurants -->

<div class="restaurant-container">

<%

if(restaurantList != null && !restaurantList.isEmpty()){

	for(Restaurant restaurant : restaurantList){

%>

<div class="card">

	<h2><%=restaurant.getRestaurantName()%></h2>

	<p>
		<b>Address :</b>
		<%=restaurant.getAddress()%>
	</p>

	<p>
		<b>Phone :</b>
		<%=restaurant.getPhone()%>
	</p>

	<div class="rating-badge">
		⭐ <%=restaurant.getRating()%>
	</div>

<a href="menu?restaurantId=<%=restaurant.getRestaurantId()%>">
    <button type="button">View Menu</button>
</a>

</div>

<%

	}

}else{

%>

<div class="no-data">

	No Restaurants Available

</div>

<%

}

%>

</div>

</body>
</html>
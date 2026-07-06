<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Orders"%>
<%@ page import="com.foodapp.model.User"%>

<%
	User user = (User) session.getAttribute("user");

	if (user == null) {
		response.sendRedirect("login.jsp");
		return;
	}

	@SuppressWarnings("unchecked")
	List<Orders> orderList = (List<Orders>) request.getAttribute("orderList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:Arial, Helvetica, sans-serif;
}

body{
	background:linear-gradient(135deg,#ff6b35,#ff914d,#ffd166);
	min-height:100vh;
}

/* Header */

.header{

	background:white;

	padding:18px 40px;

	display:flex;

	justify-content:space-between;

	align-items:center;

	box-shadow:0 3px 10px rgba(0,0,0,.2);
}

.header h1{

	color:#ff6b35;

	font-size:30px;
}

.header .right{

	display:flex;

	align-items:center;

	gap:20px;
}

.header span{

	color:#555;

	font-weight:bold;
}

.header a{

	text-decoration:none;

	color:#ff6b35;

	font-weight:bold;

	transition:.3s;
}

.header a:hover{

	color:#d94f1b;
}

/* Main Container */

.container{

	width:90%;

	max-width:1100px;

	margin:40px auto;

	background:white;

	padding:30px;

	border-radius:15px;

	box-shadow:0 10px 25px rgba(0,0,0,.25);
}

.title{

	text-align:center;

	color:#ff6b35;

	margin-bottom:25px;

	font-size:28px;
}

/* Table */

table{

	width:100%;

	border-collapse:collapse;

	overflow:hidden;
}

th{

	background:#ff6b35;

	color:white;

	padding:15px;
}

td{

	padding:15px;

	text-align:center;

	border-bottom:1px solid #eee;
}

tr:nth-child(even){

	background:#fafafa;
}

tr:hover{

	background:#fff3ed;
}

/* Status */

.status{

	padding:8px 15px;

	border-radius:20px;

	color:white;

	font-size:13px;

	font-weight:bold;
}

.pending{

	background:#ffc107;

	color:#000;
}

.preparing{

	background:#17a2b8;
}

.delivered{

	background:#28a745;
}

/* View Button */

.view-btn{

	display:inline-block;

	padding:8px 18px;

	background:#ff6b35;

	color:white;

	text-decoration:none;

	border-radius:6px;

	font-weight:bold;

	transition:.3s;
}

.view-btn:hover{

	background:#e65a28;
}

/* Empty Orders */

.no-data{

	text-align:center;

	padding:50px;
}

.no-data h2{

	color:#ff6b35;

	margin-bottom:15px;
}

.no-data p{

	color:#666;

	margin-bottom:25px;
}

.order-btn{

	display:inline-block;

	padding:12px 25px;

	background:#28a745;

	color:white;

	text-decoration:none;

	border-radius:8px;

	font-weight:bold;

	transition:.3s;
}

.order-btn:hover{

	background:#1f8d3b;
}

/* Footer */

.footer{

	text-align:center;

	margin-top:30px;

	color:#777;

	font-size:14px;
}

</style>

</head>

<body>

<div class="header">

	<h1>🍽 Food Ordering App</h1>

	<div class="right">

		<span>Welcome, <%=user.getName()%></span>

		<a href="restaurants">🏠 Home</a>

		<a href="logout">🚪 Logout</a>

	</div>

</div>

<div class="container">

<h2 class="title">📦 My Orders</h2>

<%

if(orderList != null && !orderList.isEmpty()){

%>

<table>

<tr>

<th>Order ID</th>

<th>Order Date</th>

<th>Total Amount</th>

<th>Status</th>

<th>Details</th>

</tr>

<%

for(Orders order : orderList){

	String statusClass="";

	if(order.getStatus().equalsIgnoreCase("Pending")){

		statusClass="pending";
	}
	else if(order.getStatus().equalsIgnoreCase("Preparing")){

		statusClass="preparing";
	}
	else{

		statusClass="delivered";
	}

%>

<tr>

<td>

#<%=order.getOrderId()%>

</td>

<td>

<%=order.getOrderDate()%>

</td>

<td>

₹ <%=order.getTotalAmount()%>

</td>

<td>

<span class="status <%=statusClass%>">

<%=order.getStatus()%>

</span>

</td>

<td>

<a class="view-btn"
href="orderConfirmation.jsp?orderId=<%=order.getOrderId()%>">

View Details

</a>

</td>

</tr>

<%

}

%>

</table>

<%

}else{

%>

<div class="no-data">

<h2>📭 No Orders Found</h2>

<p>You haven't placed any orders yet.</p>

<a href="restaurants" class="order-btn">

🍔 Order Now

</a>

</div>

<%

}

%>

<div class="footer">

Thank you for choosing our Food Ordering App ❤️

</div>

</div>

</body>
</html>
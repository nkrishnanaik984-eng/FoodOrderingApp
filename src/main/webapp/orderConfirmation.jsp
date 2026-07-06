<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.OrderItem"%>
<%@ page import="com.foodapp.model.User"%>
<%@ page import="com.foodapp.dao.OrderDAO"%>
<%@ page import="com.foodapp.dao.impl.OrderDAOImpl"%>

<%
	User user = (User) session.getAttribute("user");

	if (user == null) {
		response.sendRedirect("login.jsp");
		return;
	}

	int orderId = Integer.parseInt(request.getParameter("orderId"));

	OrderDAO orderDAO = new OrderDAOImpl();
	List<OrderItem> itemList = orderDAO.getOrderItemsByOrderId(orderId);

	double totalAmount = 0;

	for (OrderItem item : itemList) {
		totalAmount += item.getSubtotal();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

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
}

.header a{

	text-decoration:none;

	color:#ff6b35;

	font-weight:bold;
}

/* Main Card */

.container{

	width:75%;

	margin:40px auto;

	background:white;

	padding:35px;

	border-radius:15px;

	box-shadow:0 10px 25px rgba(0,0,0,.25);
}

/* Success */

.success{

	text-align:center;

	font-size:35px;

	margin-bottom:10px;
}

.success-msg{

	text-align:center;

	font-size:28px;

	color:#28a745;

	font-weight:bold;
}

.order-id{

	text-align:center;

	margin:15px 0 30px;

	font-size:18px;

	color:#555;
}

/* Table */

table{

	width:100%;

	border-collapse:collapse;

	margin-top:20px;
}

th{

	background:#ff6b35;

	color:white;

	padding:15px;
}

td{

	padding:15px;

	text-align:center;

	border-bottom:1px solid #ddd;
}

tr:hover{

	background:#f8f8f8;
}

.total{

	background:#f5f5f5;

	font-size:20px;

	font-weight:bold;
}

.total td{

	color:#28a745;
}

/* Buttons */

.button-container{

	text-align:center;

	margin-top:35px;
}

.btn{

	display:inline-block;

	padding:12px 28px;

	margin:10px;

	border-radius:8px;

	text-decoration:none;

	font-size:17px;

	font-weight:bold;

	transition:.3s;
}

.home{

	background:#ff6b35;

	color:white;
}

.home:hover{

	background:#e85b25;
}

.order{

	background:#28a745;

	color:white;
}

.order:hover{

	background:#1f8a39;
}

.footer{

	margin-top:30px;

	text-align:center;

	color:#777;

	font-size:14px;
}

</style>

</head>

<body>

<div class="header">

<h1>🍔 Food Ordering App</h1>

<div>

Welcome,

<b><%=user.getName()%></b>

&nbsp;&nbsp;

<a href="logout">Logout</a>

</div>

</div>

<div class="container">

<div class="success">

🎉

</div>

<div class="success-msg">

Order Placed Successfully!

</div>

<div class="order-id">

Your Order ID is

<b>#<%=orderId%></b>

</div>

<table>

<tr>

<th>Food Item</th>

<th>Quantity</th>

<th>Subtotal</th>

</tr>

<%

for(OrderItem item : itemList){

%>

<tr>

<td>

<%=item.getItemName()%>

</td>

<td>

<%=item.getQuantity()%>

</td>

<td>

₹ <%=item.getSubtotal()%>

</td>

</tr>

<%

}

%>

<tr class="total">

<td colspan="2">

Grand Total

</td>

<td>

₹ <%=totalAmount%>

</td>

</tr>

</table>

<div class="button-container">

<a href="restaurants" class="btn home">

🏠 Back To Home

</a>

<a href="restaurants" class="btn order">

🍽 Order Again

</a>

</div>

<div class="footer">

Thank you for ordering with us ❤️

We hope to serve you again!

</div>

</div>

</body>
</html>
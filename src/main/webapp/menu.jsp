<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Menu"%>
<%@ page import="com.foodapp.model.User"%>

<%
    // Check whether the user is logged in
    User user = (User) session.getAttribute("user");

    if(user == null){
        response.sendRedirect("login.jsp");
        return;
    }

    @SuppressWarnings("unchecked")
    List<Menu> menuList = (List<Menu>)request.getAttribute("menuList");

    Integer restaurantId = (Integer)request.getAttribute("restaurantId");
    // Fallback block to prevent form crashes if restaurantId isn't forwarded smoothly
    if (restaurantId == null && menuList != null && !menuList.isEmpty()) {
        restaurantId = menuList.get(0).getRestaurantId();
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f4f4;
}

.header{
    background:#ff6b35;
    color:white;
    padding:20px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.header-right {
    display: flex;
    align-items: center;
    gap: 20px;
}

.header a{
    color:white;
    text-decoration:none;
    font-weight:bold;
    transition: opacity 0.2s;
}

.header a:hover {
    opacity: 0.8;
}

/* Styled Cart Link to stand out */
.cart-link {
    background-color: #ffffff;
    color: #ff6b35 !important;
    padding: 8px 15px;
    border-radius: 20px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}

.container{
    width:90%;
    margin:30px auto;
    display:flex;
    flex-wrap:wrap;
    justify-content:center;
    gap:20px;
}

.card{
    width:300px;
    background:white;
    border-radius:10px;
    box-shadow:0 0 8px lightgray;
    padding:20px;
    transition:.3s;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.card:hover{
    transform:scale(1.03);
}

.card h2{
    color:#ff6b35;
    margin-bottom:10px;
    font-size: 22px;
}

.card p{
    margin:8px 0;
    color: #444;
}

.price{
    color:green;
    font-size:20px;
    font-weight:bold;
}

.available{
    color:green;
    font-weight:bold;
}

.unavailable{
    color:red;
    font-weight:bold;
}

.quantity-container {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 10px;
}

.quantity-container label {
    font-weight: bold;
    font-size: 14px;
}

.quantity-input {
    width: 60px;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 4px;
    text-align: center;
}

button{
    width:100%;
    padding:10px;
    background:#28a745;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
    margin-top:15px;
    font-weight: bold;
}

button:hover{
    background:#1e7e34;
}

.no-data{
    text-align:center;
    margin-top:80px;
    color:red;
    font-size:22px;
}

</style>

</head>

<body>

<div class="header">

    <h1>Restaurant Menu</h1>

    <div class="header-right">
    
        <span>Welcome <b><%=user.getName()%></b></span>
    
        <a href="restaurants">Home</a>
        
        <a href="viewCart" class="cart-link">🛒 View Cart</a>
    
        <a href="logout">Logout</a>
    
    </div>

</div>

<div class="container">

<%
if(menuList != null && !menuList.isEmpty()){
    for(Menu menu : menuList){
%>

<div class="card">
    <div>
        <img src="<%=menu.getImageUrl()%>"
             alt="<%=menu.getItemName()%>"
             style="width:100%; height:180px; object-fit:cover; border-radius:8px; margin-bottom:10px;">
        
        <h2><%=menu.getItemName()%></h2>
        
        <p>
            <b>Description:</b> <%=menu.getDescription()%>
        </p>
        
        <p class="price">
            ₹ <%=menu.getPrice()%>
        </p>
        
        <p>
            Availability: 
            <% if(menu.getAvailability().equalsIgnoreCase("Available")){ %>
                <span class="available">Available</span>
            <% } else { %>
                <span class="unavailable">Not Available</span>
            <% } %>
        </p>
    </div>

    <% if(menu.getAvailability().equalsIgnoreCase("Available")){ %>
        <form action="cart" method="post">
            <input type="hidden" name="menuId" value="<%=menu.getMenuId()%>">
            <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
            
            <div class="quantity-container">
                <label>Qty:</label>
                <input type="number" name="quantity" value="1" min="1" class="quantity-input">
            </div>
            
            <button type="submit">Add To Cart</button>
        </form>
    <% } else { %>
        <button style="background: #999; cursor: not-allowed;" disabled>Out of Stock</button>
    <% } %>
</div>

<%
    }
} else {
%>
    <div class="no-data">
        No Menu Items Found
    </div>
<%
}
%>

</div>

</body>
</html>
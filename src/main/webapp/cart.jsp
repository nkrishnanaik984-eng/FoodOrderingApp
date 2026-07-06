<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Cart"%>
<%@ page import="com.foodapp.model.User"%>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    @SuppressWarnings("unchecked")
    List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
    double totalAmount = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Cart | FoodApp</title>
    <style>
        /* Modern Reset & Background Setup */
        * { 
            margin: 0; 
            padding: 0; 
            box-sizing: border-box; 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
        }
        
        body { 
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8f0 100%); 
            min-height: 100vh;
            color: #333;
            padding: 40px 20px;
        }

        /* Centered Main Wrapper Card */
        .cart-container {
            max-width: 1000px;
            margin: 0 auto;
            background: #ffffff;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
            overflow: hidden;
        }

        /* Premium Gradient Header Section */
        .cart-header {
            background: linear-gradient(135deg, #ff6b35 0%, #ff4f13 100%);
            color: white;
            padding: 30px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .cart-header h2 {
            font-size: 26px;
            font-weight: 600;
            letter-spacing: -0.5px;
        }

        .user-badge {
            background: rgba(255, 255, 255, 0.2);
            padding: 6px 14px;
            border-radius: 20px;
            font-size: 14px;
        }

        /* Content Wrapper */
        .cart-content {
            padding: 40px;
        }

        /* Table Styling */
        table { 
            width: 100%; 
            border-collapse: separate; 
            border-spacing: 0;
            margin-top: 10px; 
        }

        th { 
            background-color: #f8fafc; 
            color: #64748b;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 13px;
            letter-spacing: 0.5px;
            padding: 16px 20px;
            border-bottom: 2px solid #e2e8f0;
            text-align: left;
        }

        td { 
            padding: 20px; 
            vertical-align: middle;
            border-bottom: 1px solid #f1f5f9;
            color: #1e293b;
            font-size: 15px;
        }

        tr:hover td {
            background-color: #f8fafc;
        }

        .item-name {
            font-weight: 600;
            color: #0f172a;
        }

        .price-tag {
            color: #475569;
        }

        .subtotal-tag {
            font-weight: 600;
            color: #2e7d32;
        }

        /* Modern Form Inputs & Inline Elements */
        .inline-form { 
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .qty-input {
            width: 60px;
            padding: 6px 8px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            text-align: center;
            font-weight: 600;
            outline: none;
            transition: border-color 0.2s;
        }

        .qty-input:focus {
            border-color: #ff6b35;
        }

        /* Action Button Refinements */
        .btn-update {
            background-color: #ffb703;
            color: #023047;
            border: none;
            padding: 7px 12px;
            font-size: 13px;
            font-weight: 600;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.2s;
        }

        .btn-update:hover {
            background-color: #fb8500;
            color: white;
        }

        .btn-delete {
            background-color: #ffeece;
            color: #d32f2f;
            border: none;
            padding: 7px 12px;
            font-size: 13px;
            font-weight: 600;
            border-radius: 6px;
            cursor: pointer;
            transition: all 0.2s;
        }

        .btn-delete:hover {
            background-color: #d32f2f;
            color: white;
        }

        /* Footer & Summary Breakdown Placement */
        .cart-summary {
            margin-top: 35px;
            padding-top: 25px;
            border-top: 2px dashed #e2e8f0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .back-link {
            color: #ff6b35;
            text-decoration: none;
            font-weight: 600;
            font-size: 15px;
            transition: opacity 0.2s;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        .total-box { 
            text-align: right; 
        }

        .total-label {
            font-size: 14px;
            color: #64748b;
            margin-bottom: 4px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .total-amount {
            font-size: 28px; 
            font-weight: 700; 
            color: #1e293b;
            margin-bottom: 15px;
        }

        .btn-checkout { 
            background: linear-gradient(135deg, #28a745 0%, #1e7e34 100%);
            color: white; 
            padding: 14px 30px; 
            text-decoration: none; 
            border-radius: 8px; 
            font-weight: 600;
            display: inline-block;
            box-shadow: 0 4px 12px rgba(40, 167, 69, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .btn-checkout:hover {
            transform: translateY(-1px);
            box-shadow: 0 6px 18px rgba(40, 167, 69, 0.3);
        }

        /* Empty State Styling */
        .empty-state {
            text-align: center;
            padding: 60px 20px;
        }

        .empty-icon {
            font-size: 64px;
            margin-bottom: 20px;
            display: block;
        }

        .empty-state p {
            font-size: 18px;
            color: #64748b;
            margin-bottom: 20px;
        }

        .btn-browse {
            background-color: #ff6b35;
            color: white;
            padding: 12px 24px;
            text-decoration: none;
            border-radius: 8px;
            font-weight: 600;
            display: inline-block;
            transition: background 0.2s;
        }

        .btn-browse:hover {
            background-color: #e05626;
        }
    </style>
</head>
<body>

    <div class="cart-container">
        <div class="cart-header">
            <h2>Your Shopping Cart</h2>
            <div class="user-badge">
                Logged in as: <b><%= user.getName() %></b>
            </div>
        </div>

        <div class="cart-content">
            <% if (cartList == null || cartList.isEmpty()) { %>
                <div class="empty-state">
                    <span class="empty-icon">🛒</span>
                    <p>Your cart is empty! Let's fill it with delicious foods.</p>
                    <a href="restaurants" class="btn-browse">Browse Restaurants</a>
                </div>
            <% } else { %>
                <table>
                    <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Subtotal</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            for (Cart c : cartList) { 
                                double subtotal = c.getPrice() * c.getQuantity();
                                totalAmount += subtotal;
                        %>
                        <tr>
                            <td class="item-name"><%= c.getItemName() %></td>
                            <td class="price-tag">₹<%= String.format("%.2f", c.getPrice()) %></td>
                            <td>
                                <form action="updateCart" method="POST" class="inline-form">
                                    <input type="hidden" name="cartId" value="<%= c.getCartId() %>">
                                    <input type="number" name="quantity" value="<%= c.getQuantity() %>" min="1" class="qty-input">
                                    <button type="submit" class="btn-update">Update</button>
                                </form>
                            </td>
                            <td class="subtotal-tag">₹<%= String.format("%.2f", subtotal) %></td>
                            <td>
                                <form action="removeCart" method="POST" class="inline-form">
                                    <input type="hidden" name="cartId" value="<%= c.getCartId() %>">
                                    <button type="submit" class="btn-delete">Delete</button>
                                </form>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>

                <div class="cart-summary">
                    <a href="restaurants" class="back-link">← Continue Shopping</a>
                    
                    <div class="total-box">
                        <div class="total-label">Grand Total</div>
                        <div class="total-amount">₹<%= String.format("%.2f", totalAmount) %></div>
<a href="checkout" class="btn-checkout">Proceed to Checkout</a>                    </div>
                </div>
            <% } %>
        </div>
    </div>

</body>
</html>
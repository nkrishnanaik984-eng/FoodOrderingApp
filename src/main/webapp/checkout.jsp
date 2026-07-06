<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.User"%>

<%
    // Ensure user session authentication check is validated
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Get the total amount passed forward safely from CheckoutServlet request scope attributes
    Double totalAmount = (Double) request.getAttribute("totalAmount");
    if (totalAmount == null) {
        totalAmount = 0.0;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout | FoodApp</title>
    <style>
        * { 
            margin: 0; 
            padding: 0; 
            box-sizing: border-box; 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
        }
        
        body { 
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8f0 100%); 
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .checkout-box { 
            background: #ffffff;
            width: 100%;
            max-width: 500px;
            padding: 40px; 
            border-radius: 16px; 
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
            text-align: center;
        }

        h2 {
            color: #ff6b35;
            margin-bottom: 20px;
            font-size: 26px;
        }

        .amount-card {
            background-color: #f8fafc;
            border: 1px solid #e2e8f0;
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 30px;
        }

        .amount-label {
            font-size: 14px;
            color: #64748b;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .amount-value {
            font-size: 32px;
            font-weight: 700;
            color: #1e293b;
            margin-top: 5px;
        }

        .btn-submit { 
            background: linear-gradient(135deg, #28a745 0%, #1e7e34 100%);
            color: white; 
            border: none; 
            padding: 14px 30px; 
            width: 100%;
            border-radius: 8px; 
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            box-shadow: 0 4px 12px rgba(40, 167, 69, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .btn-submit:hover {
            transform: translateY(-1px);
            box-shadow: 0 6px 18px rgba(40, 167, 69, 0.3);
        }

        .cancel-link {
            display: block;
            margin-top: 20px;
            color: #64748b;
            text-decoration: none;
            font-size: 14px;
        }

        .cancel-link:hover {
            text-decoration: underline;
            color: #ff6b35;
        }
    </style>
</head>
<body>

    <div class="checkout-box">
        <h2>Confirm Your Order</h2>
        
        <div class="amount-card">
            <div class="amount-label">Total Payment Due</div>
            <div class="amount-value">₹<%= String.format("%.2f", totalAmount) %></div>
        </div>

        <form action="placeOrder" method="POST">
            <button type="submit" class="btn-submit">Place Order</button>
        </form>

        <a href="viewCart" class="cancel-link">Cancel & Return to Cart</a>
    </div>

</body>
</html>
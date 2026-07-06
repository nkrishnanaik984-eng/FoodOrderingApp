package com.foodapp.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import com.foodapp.dao.CartDAO;
import com.foodapp.dao.OrderDAO;
import com.foodapp.dao.impl.CartDAOImpl;
import com.foodapp.dao.impl.OrderDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.OrderItem;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO = new CartDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getUserId();

        // 1. Try fetching cart items from the database table via DAO
        List<Cart> cartList = cartDAO.getCartByUser(userId);

        // FALLBACK: If database items come back empty, read from active HTTP Session memory
        if (cartList == null || cartList.isEmpty()) {
            @SuppressWarnings("unchecked")
            List<Cart> sessionCart = (List<Cart>) session.getAttribute("cartList");
            cartList = sessionCart;
        }

        // Final Guard Clause: If both states are empty, safe exit to cart layout
        if (cartList == null || cartList.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        // 2. Compute grand total cost valuation
        double totalAmount = 0;
        for (Cart c : cartList) {
            totalAmount += (c.getPrice() * c.getQuantity());
        }

        // 3. Assemble and initialize primary Orders model record instance
        Orders order = new Orders();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setStatus("Pending");

        // 4. Save order to DB and grab generated key ID reference auto-increment assignment
        int newOrderId = orderDAO.placeOrder(order);

        if (newOrderId != -1) {

            // 5. Run sequential loops to map individual menu items to the order_item table layout
            for (Cart c : cartList) {
                OrderItem item = new OrderItem();
                item.setOrderId(newOrderId);
                item.setMenuId(c.getMenuId());
                item.setQuantity(c.getQuantity());
                item.setSubtotal(c.getPrice() * c.getQuantity());

                orderDAO.addOrderItem(item);
            }

            // 6. Purge temporary item holding logs across DB and local scopes
            cartDAO.clearCart(userId);
            session.removeAttribute("cartList"); 

            // 7. Route control internally using request dispatching to handle confirmation view logic safely
            request.setAttribute("orderId", newOrderId);
            
            // ====================================================================
            // FIXED HERE: Changed from "/orderConfirmation.jsp" to "/orderSuccess.jsp"
            // ====================================================================
            request.getRequestDispatcher("/orderSuccess.jsp").forward(request, response);

        } else {
            // Failed database insertion transactional tracking fallback exit mapping
            response.sendRedirect("cart.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Reroute arbitrary GET requests safely back into standard transaction validation block
        doPost(request, response);
    }
}
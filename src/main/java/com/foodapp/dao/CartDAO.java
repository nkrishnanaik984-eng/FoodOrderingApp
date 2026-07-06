package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Cart;

public interface CartDAO {

    boolean addToCart(Cart cart);

    List<Cart> getCartByUser(int userId);

    boolean updateQuantity(int cartId, int quantity);

    boolean removeCartItem(int cartId);

    boolean clearCart(int userId);

    Cart getCartItemByUserAndMenu(int userId, int menuId);
}
package com.example.onlineshop.service;


import com.example.onlineshop.entity.Cart;
import com.example.onlineshop.entity.ProductInOrder;
import com.example.onlineshop.entity.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}

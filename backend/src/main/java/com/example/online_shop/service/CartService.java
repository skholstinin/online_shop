package com.example.online_shop.service;


import com.example.online_shop.entity.Cart;
import com.example.online_shop.entity.ProductInOrder;
import com.example.online_shop.entity.User;

import java.util.Collection;

public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}

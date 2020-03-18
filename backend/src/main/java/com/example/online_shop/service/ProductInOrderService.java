package com.example.online_shop.service;

import com.example.online_shop.entity.ProductInOrder;
import com.example.online_shop.entity.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);

    ProductInOrder findOne(String itemId, User user);
}

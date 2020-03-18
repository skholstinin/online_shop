package com.example.onlineshop.service;

import com.example.onlineshop.entity.ProductInOrder;
import com.example.onlineshop.entity.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);

    ProductInOrder findOne(String itemId, User user);
}

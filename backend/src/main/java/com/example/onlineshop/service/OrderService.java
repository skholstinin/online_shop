package com.example.onlineshop.service;


import com.example.onlineshop.entity.OrderMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderMain> findAll(Pageable pageable);

    Page<OrderMain> findByStatus(Integer status, Pageable pageable);

    Page<OrderMain> findByBuyerEmail(String email, Pageable pageable);

    OrderMain findOne(Long orderId);


    OrderMain finish(Long orderId);

    OrderMain cancel(Long orderId);

}

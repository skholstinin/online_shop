package com.example.online_shop.repository;

import com.example.online_shop.entity.OrderMain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderMain, Integer> {
    OrderMain findByOrderId(Long orderId);

    Page<OrderMain> findAllByOrderStatusOrderByCreateTimeDesc(Integer orderStatus, Pageable pageable);

    Page<OrderMain> findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(String buyerEmail, Pageable pageable);

    Page<OrderMain> findAllByOrderByOrderStatusAscCreateTimeDesc(Pageable pageable);
}

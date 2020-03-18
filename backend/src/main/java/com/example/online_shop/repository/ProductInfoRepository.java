package com.example.online_shop.repository;

import com.example.online_shop.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    ProductInfo findByProductId(String id);

    Page<ProductInfo> findAllByProductStatusOrderByProductIdAsc(Integer productStatus, Pageable pageable);

    Page<ProductInfo> findAllByOrderByProductId(Pageable pageable);
}

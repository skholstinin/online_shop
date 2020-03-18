package com.example.online_shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.online_shop.entity.OrderMain;
import com.example.online_shop.entity.ProductInOrder;
import com.example.online_shop.entity.ProductInfo;
import com.example.online_shop.enums.OrderStatusEnum;
import com.example.online_shop.enums.ResultEnum;
import com.example.online_shop.exception.MyException;
import com.example.online_shop.repository.OrderRepository;
import com.example.online_shop.repository.ProductInOrderRepository;
import com.example.online_shop.repository.ProductInfoRepository;
import com.example.online_shop.repository.UserRepository;
import com.example.online_shop.service.OrderService;
import com.example.online_shop.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductInfoRepository productInfoRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @Override
    public Page<OrderMain> findAll(Pageable pageable) {
        return orderRepository.findAllByOrderByOrderStatusAscCreateTimeDesc(pageable);
    }

    @Override
    public Page<OrderMain> findByStatus(Integer status, Pageable pageable) {
        return orderRepository.findAllByOrderStatusOrderByCreateTimeDesc(status, pageable);
    }

    @Override
    public Page<OrderMain> findByBuyerEmail(String email, Pageable pageable) {
        return orderRepository.findAllByBuyerEmailOrderByOrderStatusAscCreateTimeDesc(email, pageable);
    }

    @Override
    public OrderMain findOne(Long orderId) {
        OrderMain orderMain = orderRepository.findByOrderId(orderId);
        if (orderMain == null) {
            throw new MyException(ResultEnum.ORDER_NOT_FOUND);
        }
        return orderMain;
    }

    @Override
    @Transactional
    public OrderMain finish(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if (!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderRepository.save(orderMain);
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public OrderMain cancel(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        if (!orderMain.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        orderMain.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
        orderRepository.save(orderMain);

        Iterable<ProductInOrder> products = orderMain.getProducts();
        for (ProductInOrder productInOrder : products) {
            ProductInfo productInfo = productInfoRepository.findByProductId(productInOrder.getProductId());
            if (productInfo != null) {
                productService.increaseStock(productInOrder.getProductId(), productInOrder.getCount());
            }
        }
        return orderRepository.findByOrderId(orderId);

    }
}

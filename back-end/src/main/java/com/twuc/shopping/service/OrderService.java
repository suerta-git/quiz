package com.twuc.shopping.service;

import com.twuc.shopping.bo.Order;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductPairRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    final private OrderRepository orderRepository;
    final private ProductPairRepository productPairRepository;

    public OrderService(OrderRepository orderRepository, ProductPairRepository productPairRepository) {
        this.orderRepository = orderRepository;
        this.productPairRepository = productPairRepository;
    }

    public void init(List<Order> orders) {
        orderRepository.saveAll(
                orders.stream()
                        .map(this::mapFromOrder)
                        .collect(Collectors.toList())
        );
    }

    public List<OrderPO> getOrders() {
        return orderRepository.findAll();
    }

    private OrderPO mapFromOrder(Order order) {
        return OrderPO.builder().productPairs(
                order.getProductPairs().stream()
                        .map(pair -> productPairRepository
                                .findById(pair.getProductId())
                                .orElseThrow(() -> new IllegalArgumentException("product not exists")))
                        .collect(Collectors.toList()))
                .build();
    }
}

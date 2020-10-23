package com.twuc.shopping.controller;

import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<OrderPO>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}

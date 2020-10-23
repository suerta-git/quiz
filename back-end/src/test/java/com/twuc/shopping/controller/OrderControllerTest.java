package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.bo.Order;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    private List<Order> orders;

    @BeforeEach
    private void init() {
        orders = new ArrayList<>(Arrays.asList(
                new Order(new ArrayList<>()),
                new Order(new ArrayList<>())
        ));
        orderService.init(orders);
    }

    @Test
    public void should_get_orders_when_request() throws Exception {
        final String json = objectMapper.writeValueAsString(orders);
        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}
package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.bo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class GoodsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_return_goods_when_request() throws Exception {
        final String url = "whatever";
        final List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("可乐1", 1, "罐", url),
                new Product("可乐2", 2.01, "罐", url),
                new Product("可乐3", 5.057, "罐", url)
                ));
        final String json = objectMapper.writeValueAsString(products);
        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}
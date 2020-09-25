package com.twuc.shopping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.bo.Product;
import com.twuc.shopping.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
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
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductService productService;

    private List<Product> products;

    @BeforeEach
    private void setUp() {
        final String url = "whatever";
        products = new ArrayList<>(Arrays.asList(
                new Product("可乐1", 1, "罐", url),
                new Product("可乐2", 2.01, "罐", url),
                new Product("可乐3", 5.057, "罐", url)
        ));
        productService.init(products);
    }

    @Test
    public void should_return_products_when_request() throws Exception {
        final String json = objectMapper.writeValueAsString(products);
        mockMvc.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}
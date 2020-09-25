package com.twuc.shopping.controller;

import com.twuc.shopping.bo.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class GoodsController {
    private final String url = "whatever";
    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("可乐1", 1, "罐", url),
            new Product("可乐2", 2.01, "罐", url),
            new Product("可乐3", 5.057, "罐", url)
    ));

    @GetMapping("/goods")
    public List<Product> getProducts() {
        return products;
    }
}

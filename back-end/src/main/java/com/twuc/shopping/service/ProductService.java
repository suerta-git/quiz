package com.twuc.shopping.service;

import com.twuc.shopping.bo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void init(List<Product> products) {
        this.products.clear();
        this.products.addAll(products);
    }
}

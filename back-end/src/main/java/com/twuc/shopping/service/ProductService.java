package com.twuc.shopping.service;

import com.twuc.shopping.bo.Product;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll().stream()
                .map(Product::new)
                .collect(Collectors.toList());
    }

    public void init(List<Product> products) {
        productRepository.deleteAll();
        productRepository.saveAll(
                products.stream()
                .map(ProductPO::new)
                .collect(Collectors.toList())
        );
    }
}

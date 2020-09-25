package com.twuc.shopping.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private String unit;
    private String image;
}

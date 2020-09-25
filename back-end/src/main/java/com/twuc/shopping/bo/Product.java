package com.twuc.shopping.bo;

import com.twuc.shopping.po.ProductPO;
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

    public Product(ProductPO productPO) {
        this.name = productPO.getName();
        this.price = productPO.getPrice();
        this.unit = productPO.getUnit();
        this.image = productPO.getImage();
    }
}

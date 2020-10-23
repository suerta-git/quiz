package com.twuc.shopping.bo;

import com.twuc.shopping.po.ProductPO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class Product {
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String unit;
    @NotNull
    private String image;

    public Product(ProductPO productPO) {
        this.name = productPO.getName();
        this.price = productPO.getPrice();
        this.unit = productPO.getUnit();
        this.image = productPO.getImage();
    }
}

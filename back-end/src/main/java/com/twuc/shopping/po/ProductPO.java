package com.twuc.shopping.po;

import com.twuc.shopping.bo.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPO {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String unit;
    private String image;

    public ProductPO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.unit = product.getUnit();
        this.image = product.getImage();
    }
}

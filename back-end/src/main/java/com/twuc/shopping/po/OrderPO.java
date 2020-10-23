package com.twuc.shopping.po;

import com.twuc.shopping.bo.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPO {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPairPO> productPairs;

    private Double totalPrice;

    public void calculateTotalPrice() {
        totalPrice = productPairs.stream()
                .map(pair -> pair.getProduct().getPrice() * pair.getAmount())
                .reduce(0.0, Double::sum);
    }
}

package com.twuc.shopping.bo;

import com.twuc.shopping.po.OrderPO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @NotNull
    @NotEmpty
    private List<ProductPair> productPairs;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductPair {
        @NotNull
        private Integer productId;

        @NotNull
        private Integer amount;
    }

    public static Order of(OrderPO orderPO) {
        return new Order(
                orderPO.getProductPairs().stream()
                        .map(pairPO -> new ProductPair(pairPO.getId(), pairPO.getAmount()))
                        .collect(Collectors.toList())
        );
    }
}

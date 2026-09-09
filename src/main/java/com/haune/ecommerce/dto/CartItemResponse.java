package com.haune.ecommerce.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemResponse {
    private Long cartItemId;
    private ProductItemResponse productItem;
    private Integer qty;
    private BigDecimal subTotal;
}

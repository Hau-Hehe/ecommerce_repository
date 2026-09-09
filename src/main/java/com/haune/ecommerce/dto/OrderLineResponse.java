package com.haune.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineResponse {
    private Long productItemId;
    private String productName;
    private Integer qty;
    private BigDecimal price;
}

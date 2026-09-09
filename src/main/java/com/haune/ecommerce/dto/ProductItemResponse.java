package com.haune.ecommerce.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItemResponse {
    private Long id;
    private String sku;
    private BigDecimal price;
    private Integer qtyInStock;
    private String productImage;
    private String productName;
    private List<String> variations; //["Màu: Đỏ", "Size: XL"]
}

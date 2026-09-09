package com.haune.ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItemCreateRequest {
    @NotNull(message = "Product ID không được để trống")
    private Long productId;

    @NotBlank(message = "SKU không được để trống")
    private String sku;

    @NotNull @Min(0)
    private Integer qtyInStock;

    private String productImage;

    @NotNull @Min(0)
    private BigDecimal price;

    private List<Long> variationOptionIds;
}

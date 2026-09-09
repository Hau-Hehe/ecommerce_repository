package com.haune.ecommerce.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionResponse {
    private Long id;
    private String name;
    private String description;
    private Double discountRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<ProductCategoryResponse> appliedCategories;
}

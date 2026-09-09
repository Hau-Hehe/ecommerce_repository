package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionRequest {
    @NotBlank(message = "Tên khuyến mãi không được để trống")
    private String name;

    private String description;

    @NotNull(message = "Tỷ lệ giảm giá không được để trống")
    private Double discountRate;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Long> categoryIds;
}

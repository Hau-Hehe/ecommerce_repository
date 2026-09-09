package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationRequest {
    @NotBlank(message = "Tên biến thể không được để trống")
    private String name;

    @NotNull(message = "Category ID không được để trống")
    private Long categoryId;
}

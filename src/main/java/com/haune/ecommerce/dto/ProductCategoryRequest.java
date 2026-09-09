package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoryRequest {
    @NotBlank(message = "Tên danh mục không được để trống")
    private String categoryName;

    private Long parentCategoryId;
}

package com.haune.ecommerce.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCategoryResponse {
    private Long id;
    private String categoryName;
    private Long parentCategoryId;
    private List<ProductCategoryResponse> subCategories;
}

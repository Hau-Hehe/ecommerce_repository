package com.haune.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationResponse {
    private Long id;
    private String name;
    private Long categoryId;
}

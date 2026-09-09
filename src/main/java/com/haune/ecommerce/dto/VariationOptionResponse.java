package com.haune.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationOptionResponse {
    private Long id;
    private String value;
    private VariationResponse variation;
}

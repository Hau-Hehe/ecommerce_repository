package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationOptionResp {
    @NotBlank(message = "Giá trị thuộc tính không được để trống")
    private String value;

    @NotNull(message = "Variation ID không được để trống")
    private Long variationId;
}

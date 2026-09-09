package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryRequest {
    @NotBlank(message = "Tên quốc gia không được để trống")
    private String countryName;
}

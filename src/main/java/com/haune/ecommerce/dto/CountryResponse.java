package com.haune.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryResponse {
    private Long id;
    private String countryName;
}

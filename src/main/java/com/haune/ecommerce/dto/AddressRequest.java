package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
    private String unitNumber;
    private String streetNumber;

    @NotBlank(message = "Địa chỉ dòng 1 không được để trống")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "Thành phố không được để trống")
    private String city;

    private String region;
    private String postalCode;

    @NotNull(message = "Country ID không được để trống")
    private Long countryId;
}

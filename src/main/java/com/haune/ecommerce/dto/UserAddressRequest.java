package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddressRequest {
    @NotNull(message = "Address ID không được để trống")
    private Long addressId;

    private Boolean isDefault;
}

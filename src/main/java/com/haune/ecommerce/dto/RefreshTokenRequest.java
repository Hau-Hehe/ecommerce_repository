package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshTokenRequest {
    @NotBlank(message = "RefreshToken không được để trống")
    private String refreshToken;
}

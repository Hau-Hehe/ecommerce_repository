package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentTypeRequest {
    @NotBlank(message = "Loại thanh toán không được để trống")
    private String value;
}

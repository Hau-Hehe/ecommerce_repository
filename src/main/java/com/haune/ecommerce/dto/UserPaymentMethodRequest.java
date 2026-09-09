package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPaymentMethodRequest {
    @NotNull(message = "Payment Type ID không được để trống")
    private Long paymentTypeId;

    @NotBlank(message = "Nhà cung cấp không được để trống")
    private String provider;

    @NotBlank(message = "Số tài khoản/thẻ không được để trống")
    private String accountNumber;

    private LocalDate expiryDate;
    private Boolean isDefault;
}

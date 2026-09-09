package com.haune.ecommerce.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPaymentMethodResponse {
    private Long id;
    private PaymentTypeResponse paymentType;
    private String provider;
    private String maskedAccountNumber;
    private LocalDate expiryDate;
    private Boolean isDefault;
}

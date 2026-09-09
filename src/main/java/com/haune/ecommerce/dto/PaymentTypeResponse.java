package com.haune.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentTypeResponse {
    private Long id;
    private String value;
}

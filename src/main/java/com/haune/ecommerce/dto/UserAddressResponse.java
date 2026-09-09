package com.haune.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddressResponse {
    private Long id;
    private AddressResponse address;
    private Boolean isDefault;
}

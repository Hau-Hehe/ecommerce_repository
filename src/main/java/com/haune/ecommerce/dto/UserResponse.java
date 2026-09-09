package com.haune.ecommerce.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    Long id;
    String email;
    String phoneNumber;
}

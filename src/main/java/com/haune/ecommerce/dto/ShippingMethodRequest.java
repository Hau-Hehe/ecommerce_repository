package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingMethodRequest {
    @NotBlank(message = "Tên hình thức vận chuyển không được để trống")
    private String name;

    @NotNull(message = "Phí vận chuyển không được để trống")
    private BigDecimal price;
}

package com.haune.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderRequest {
    @NotNull(message = "Phương thức thanh toán không được để trống")
    private Long paymentMethodId;

    @NotNull(message = "Địa chỉ giao hàng không được để trống")
    private Long shippingAddressId;

    @NotNull(message = "Phương thức vận chuyển không được để trống")
    private Long shippingMethodId;

    private List<CartItemRequest> items;
}

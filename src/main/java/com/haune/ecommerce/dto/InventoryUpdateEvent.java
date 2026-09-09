package com.haune.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryUpdateEvent {
    private Long orderId;
    private Long productItemId;
    private Integer quantityToDeduct;
    private String actionType;
}

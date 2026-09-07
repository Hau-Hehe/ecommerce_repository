package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_configuration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductConfiguration {
    @EmbeddedId
    private ProductConfigurationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productItemId")
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("variationOptionId")
    @JoinColumn(name = "variation_option_id")
    private VariationOption variationOption;
}

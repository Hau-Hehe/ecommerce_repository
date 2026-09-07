package com.haune.ecommerce.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductConfigurationId implements Serializable {
    private Long productItemId;
    private Long variationOptionId;
}

package com.haune.ecommerce.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PromotionCategoryId {
    private Long categoryId;
    private Long promotionId;
}

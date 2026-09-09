package com.haune.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReviewResponse {
    private Long id;
    private Long userId;
    private Long orderedProductId;
    private Integer ratingValue;
    private String comment;
}

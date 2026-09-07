package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordered_product_id", nullable = false)
    private OrderLine orderedProduct;

    @Column(name = "rating_value", nullable = false)
    private Integer ratingValue;

    @Column(columnDefinition = "TEXT")
    private String comment;
}

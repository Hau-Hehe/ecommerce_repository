package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "variation_option")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variation_id", nullable = false)
    private Variation variation;
}

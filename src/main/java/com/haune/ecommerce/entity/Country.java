package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String countryName;
}

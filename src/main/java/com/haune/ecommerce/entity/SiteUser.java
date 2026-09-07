package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "site_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email_address", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String password;
}

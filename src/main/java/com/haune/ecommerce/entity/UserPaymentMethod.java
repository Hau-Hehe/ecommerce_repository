package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_payment_method")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

    private String provider;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "is_default")
    private Boolean isDefault;
}

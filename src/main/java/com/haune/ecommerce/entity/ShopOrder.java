package com.haune.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private UserPaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address", nullable = false)
    private Address shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_method", nullable = false)
    private ShippingMethod shippingMethod;

    @Column(name = "order_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal orderTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status", nullable = false)
    private OrderStatus orderStatus;
}

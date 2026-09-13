package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {
    @Query("SELECT o FROM ShopOrder o " +
            "JOIN FETCH o.user " +
            "JOIN FETCH o.orderStatus " +
            "JOIN FETCH o.shippingMethod " +
            "WHERE o.user.id = :userId ORDER BY o.orderDate DESC")
    List<ShopOrder> findByUserIdWithDetails(@Param("userId") Long userId);

    @Query("SELECT o FROM ShopOrder o " +
            "JOIN FETCH o.user " +
            "JOIN FETCH o.orderStatus " +
            "JOIN FETCH o.shippingAddress " +
            "JOIN FETCH o.shippingMethod " +
            "WHERE o.id = :id")
    Optional<ShopOrder> findByIdWithDetails(@Param("id") Long id);
}

package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    Optional<ProductItem> findBySku(String sku);

    List<ProductItem> findByProductId(Long productId);

    @Modifying
    @Query("UPDATE ProductItem pi SET pi.qtyInStock = pi.qtyInStock - :quantity WHERE pi.id = :id AND pi.qtyInStock >= :quantity")
    int deductStock(@Param("id") Long id, @Param("quantity") Integer quantity);

    @Modifying
    @Query("UPDATE ProductItem pi SET pi.qtyInStock = pi.qtyInStock + :quantity WHERE pi.id = :id")
    int restock(@Param("id") Long id, @Param("quantity") Integer quantity);
}

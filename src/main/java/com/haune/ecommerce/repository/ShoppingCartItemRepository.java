package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.ShoppingCartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartItemRepository {
    @Query("SELECT sci FROM ShoppingCartItem sci JOIN FETCH sci.productItem WHERE sci.cart.id = :cartId")
    List<ShoppingCartItem> findByCartIdWithProductItem(@Param("cartId") Long cartId);

    Optional<ShoppingCartItem> findByCartIdAndProductItemId(Long cartId, Long productItemId);

    void deleteByCartId(Long cartId);
}

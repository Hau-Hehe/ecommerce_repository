package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    @Query("SELECT ol FROM OrderLine ol JOIN FETCH ol.productItem pi JOIN FETCH pi.product WHERE ol.order.id = :orderId")
    List<OrderLine> findByOrderIdWithProductDetails(@Param("orderId") Long orderId);
}

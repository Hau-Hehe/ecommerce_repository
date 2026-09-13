package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.ProductConfiguration;
import com.haune.ecommerce.entity.ProductConfigurationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tools.jackson.core.util.RecyclerPool;

import java.util.List;

@Repository
public interface ProductConfigurationRepository extends JpaRepository<ProductConfiguration, ProductConfigurationId> {
    @Query("SELECT pc FROM ProductConfiguration pc " +
            "JOIN FETCH pc.variationOption vo " +
            "JOIN FETCH vo.variation " +
            "WHERE pc.productItem.id = :productItemId")
    List<ProductConfiguration> findByProductItemIdWithOptionDetails(@Param("productItemId") Long productItemId);
}

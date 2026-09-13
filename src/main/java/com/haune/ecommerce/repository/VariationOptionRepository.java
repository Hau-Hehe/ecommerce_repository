package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.VariationOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariationOptionRepository extends JpaRepository<VariationOption, Long> {
    List<VariationOption> findByVariationIdWithVariation(@Param("variationId") Long variationId);
}

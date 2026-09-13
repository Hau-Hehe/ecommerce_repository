package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariationRepository extends JpaRepository<Variation, Long> {
    List<Variation> findByCategoryId(Long categoryId);
}

package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.PromotionCategory;
import com.haune.ecommerce.entity.PromotionCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionCategoryRepository extends JpaRepository<PromotionCategory, PromotionCategoryId> {
    List<PromotionCategory> findByCategoryId(Long categoryId);

    List<PromotionCategory> findByPromotionId(Long promotionId);

}

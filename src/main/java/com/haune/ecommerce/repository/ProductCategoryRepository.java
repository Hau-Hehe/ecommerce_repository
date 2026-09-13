package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByParentCategoryIsNull();

    @Query("SELECT DISTINCT c FROM ProductCategory c LEFT JOIN FETCH c.subCategories WHERE c.parentCategory IS NULL")
    List<ProductCategory> findAllRootCategoriesWithSub();
}

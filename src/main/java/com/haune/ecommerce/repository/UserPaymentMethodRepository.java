package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Long> {
    @Query("SELECT upm FROM UserPaymentMethod upm JOIN FETCH upm.paymentType WHERE upm.user.id = :userId")
    List<UserPaymentMethod> findByUserIdWithPaymentType(@Param("userId") Long userId);
}

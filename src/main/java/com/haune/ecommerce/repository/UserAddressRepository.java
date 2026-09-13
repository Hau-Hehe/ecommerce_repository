package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    @Query("SELECT ua FROM UserAddress ua JOIN FETCH ua.address a JOIN FETCH a.country WHERE ua.user.id = :userId")
    List<UserAddress> findByUserIdWithAddress(@Param("userId") Long userId);
    List<UserAddress> findByUserIdAndIsDefaultTrue(Long userId);
}

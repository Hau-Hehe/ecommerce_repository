package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM ADDRESS a JOIN FETCH a.country WHERE a.id = :id")
    Optional<Address> findByIdWithCountry(@Param("id") Long id);
}
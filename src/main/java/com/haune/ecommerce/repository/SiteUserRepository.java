package com.haune.ecommerce.repository;

import com.haune.ecommerce.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByEmailAddress(String emailAddress);

    boolean existsByEmailAddress(String emailAddress);
}

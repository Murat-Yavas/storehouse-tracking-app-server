package com.devtech.StorehouseTrackingApp.repositories;

import com.devtech.StorehouseTrackingApp.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByUserId(Long userId);
}

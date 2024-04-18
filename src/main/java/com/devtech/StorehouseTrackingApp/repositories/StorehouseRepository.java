package com.devtech.StorehouseTrackingApp.repositories;

import com.devtech.StorehouseTrackingApp.entities.Storehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorehouseRepository extends JpaRepository<Storehouse, Long> {
    Storehouse findByAddress(String storehouseAddress);
}

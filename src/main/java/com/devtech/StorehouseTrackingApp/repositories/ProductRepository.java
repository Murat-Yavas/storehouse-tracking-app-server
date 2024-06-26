package com.devtech.StorehouseTrackingApp.repositories;

import com.devtech.StorehouseTrackingApp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStorehouseId(@Param("storehouseId") Long storehouseId);
}

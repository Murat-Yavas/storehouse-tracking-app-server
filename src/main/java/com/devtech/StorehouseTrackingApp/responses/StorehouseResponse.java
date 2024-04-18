package com.devtech.StorehouseTrackingApp.responses;

import com.devtech.StorehouseTrackingApp.entities.Product;
import com.devtech.StorehouseTrackingApp.entities.Storehouse;
import lombok.Data;

import java.util.List;

@Data
public class StorehouseResponse {

    private Long id;
    private String name;
    private int storageCapacity;
    private String address;
    private List<Product> products;
    private Long userId;

    public StorehouseResponse(Storehouse entity, List<Product> products) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.storageCapacity = entity.getStorageCapacity();
        this.address = entity.getAddress();
        this.products = products;
        this.userId = entity.getUser().getId();
    }
}

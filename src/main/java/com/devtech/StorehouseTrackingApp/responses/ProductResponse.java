package com.devtech.StorehouseTrackingApp.responses;

import com.devtech.StorehouseTrackingApp.entities.Product;
import lombok.Data;

@Data
public class ProductResponse {

    private Long id;
    private double entryPrice;
    private int quantity;
    private String productName;
    private String entryDate;
    private String storehouseName;

    public ProductResponse(Product entity) {
        this.id = entity.getId();
        this.entryPrice = entity.getEntryPrice();
        this.quantity = entity.getQuantity();
        this.productName = entity.getProductName();
        this.entryDate = entity.getEntryDate();
        this.storehouseName = entity.getStorehouse().getName();
    }
}

package com.devtech.StorehouseTrackingApp.requests;

import lombok.Data;

@Data
public class ProductUpdateRequest {

    private double entryPrice;
    private int quantity;
    private String productName;
    private Long storehouseId;
}

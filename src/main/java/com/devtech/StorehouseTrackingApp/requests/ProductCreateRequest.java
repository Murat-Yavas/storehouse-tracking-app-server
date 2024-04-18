package com.devtech.StorehouseTrackingApp.requests;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class ProductCreateRequest {

    private Long id;
    private double entryPrice;
    private int quantity;
    private String productName;
    private Long storehouseId;
}

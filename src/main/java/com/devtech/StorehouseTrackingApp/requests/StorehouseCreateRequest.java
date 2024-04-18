package com.devtech.StorehouseTrackingApp.requests;

import lombok.Data;

@Data
public class StorehouseCreateRequest {

    private String name;
    private int storageCapacity;
    private String address;
    private Long userId;
}

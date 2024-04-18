package com.devtech.StorehouseTrackingApp.requests;

import lombok.Data;

@Data
public class RefreshRequest {

    private Long userId;
    private String refreshToken;
}

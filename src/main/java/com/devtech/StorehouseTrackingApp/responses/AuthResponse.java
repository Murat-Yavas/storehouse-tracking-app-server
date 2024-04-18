package com.devtech.StorehouseTrackingApp.responses;

import lombok.Data;

@Data
public class AuthResponse {

    private String userName;
    private String message;
    private Long userId;
    private String accessToken;
    private String refreshToken;
}

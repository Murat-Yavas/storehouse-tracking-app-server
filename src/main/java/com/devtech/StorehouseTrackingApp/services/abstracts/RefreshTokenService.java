package com.devtech.StorehouseTrackingApp.services.abstracts;

import com.devtech.StorehouseTrackingApp.entities.RefreshToken;
import com.devtech.StorehouseTrackingApp.entities.User;

public interface RefreshTokenService {

    boolean isRefreshExpired(RefreshToken token);

    String createRefreshToken(User user);

    RefreshToken getByUser(Long userId);
}

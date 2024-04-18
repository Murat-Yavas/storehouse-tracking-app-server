package com.devtech.StorehouseTrackingApp.services.concretes;

import com.devtech.StorehouseTrackingApp.entities.RefreshToken;
import com.devtech.StorehouseTrackingApp.entities.User;
import com.devtech.StorehouseTrackingApp.repositories.RefreshTokenRepository;
import com.devtech.StorehouseTrackingApp.services.abstracts.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenManager implements RefreshTokenService {

    @Value("${refresh.token.expires.in}")
    private Long expireSeconds;

    private RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenManager(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }


    @Override
    public boolean isRefreshExpired(RefreshToken token) {
        return token.getExpiryDate().before(new Date());
    }

    @Override
    public String createRefreshToken(User user) {
        RefreshToken token = refreshTokenRepository.findByUserId(user.getId());
        if(token == null) {
            token =	new RefreshToken();
            token.setUser(user);
        }
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenRepository.save(token);
        return token.getToken();
    }

    @Override
    public RefreshToken getByUser(Long userId) {
        return refreshTokenRepository.findByUserId(userId);
    }
}

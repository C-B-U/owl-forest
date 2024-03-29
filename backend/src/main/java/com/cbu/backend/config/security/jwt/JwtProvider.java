package com.cbu.backend.config.security.jwt;

import com.cbu.backend.config.security.oauth2.LoginUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * jwt token을 생성
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final Key key;

    private static final Long ACCESS_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 1000; // 1 Day
    private static final Long REFRESH_TOKEN_VALIDATION_SECOND = 60L * 60 * 24 * 14 * 1000; // 14 Day

    public JwtToken createJWTTokens(LoginUser loginUser) {
        Claims claims = getClaims(loginUser);

        String accessToken = getToken(loginUser, claims, ACCESS_TOKEN_VALIDATION_SECOND);
        String refreshToken = getToken(loginUser, claims, REFRESH_TOKEN_VALIDATION_SECOND);

        return JwtToken.builder()
                .grantType("bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private Claims getClaims(LoginUser loginUser) {
        Claims claims = Jwts.claims();
        claims.put("id", loginUser.getName());
        return claims;
    }

    private String getToken(LoginUser loginUser, Claims claims, Long validationSecond) {
        long now = new Date().getTime();

        return Jwts.builder()
                .setSubject(loginUser.getName())
                .setClaims(claims)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date(now + validationSecond))
                .compact();
    }
}

package com.cbu.backend.config.security.jwt;

import com.cbu.backend.authaccount.command.domain.AuthAccount;
import com.cbu.backend.authaccount.mapper.AuthAccountMapper;
import com.cbu.backend.authaccount.query.service.AuthAccountQueryService;
import com.cbu.backend.config.security.oauth2.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;
import java.util.UUID;

/**
 * jwt token을 검증
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class JwtValidator {
    private final Key key;
    private final AuthAccountQueryService authAccountQueryService;
    private final AuthAccountMapper authAccountMapper;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getTokenBodyClaims(accessToken);
        AuthAccount authAccount = authAccountQueryService.findByUUID(extractUUID(claims));
        LoginUser loginUser = authAccountMapper.mapToLoginUser(authAccount);

        return new UsernamePasswordAuthenticationToken(loginUser, "", loginUser.getAuthorities());
    }

    /**
     * 토큰 내의 Claim에서 사용자 권한 List 추출
     *
     * @param claims
     * @return Collection<? extends GrantedAuthority>
     * @author Hyeonjun Park
     * @deprecated 
     */
    private Collection<? extends GrantedAuthority> extractAuthority(Claims claims) {

        return authAccountQueryService.getAuthority(extractUUID(claims));
    }

    private UUID extractUUID(Claims claims) {
        return UUID.fromString(claims.get("id", String.class));
    }

    private Claims getTokenBodyClaims(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }
}

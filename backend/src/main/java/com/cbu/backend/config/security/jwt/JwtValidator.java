package com.cbu.backend.config.security.jwt;

import com.cbu.backend.config.security.oauth2.LoginUser;
import com.cbu.backend.config.security.oauth2.LoginUserMapper;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.service.MemberService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
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
    private final MemberService memberService;
    private final LoginUserMapper loginUserMapper;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getTokenBodyClaims(accessToken);
        Member member = memberService.getEntity(extractUUID(claims));
        LoginUser loginUser = loginUserMapper.mapToLoginUser(member);

        return new UsernamePasswordAuthenticationToken(loginUser, "", loginUser.getAuthorities());
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

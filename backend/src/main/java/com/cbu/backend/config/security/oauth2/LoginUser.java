package com.cbu.backend.config.security.oauth2;

import io.jsonwebtoken.Claims;
import lombok.Getter;

/**
 * login 유저정보에 대한 dto
 *
 * @author Hyeonjun Park
 */
@Getter
public class LoginUser {
    private Long id;
    private String nickname;

    public LoginUser(Claims claims) {
        this.id = Long.parseLong(claims.get("id").toString());
        this.nickname = claims.get("nickname").toString();
    }

    public LoginUser(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}

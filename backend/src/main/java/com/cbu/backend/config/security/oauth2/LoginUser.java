package com.cbu.backend.config.security.oauth2;

import com.cbu.backend.authaccount.command.domain.AccountNo;

import io.jsonwebtoken.Claims;

import lombok.Getter;

/**
 * login 유저정보에 대한 dto
 *
 * @author Hyeonjun Park
 */
@Getter
public class LoginUser {
    private AccountNo accountId;

    public LoginUser(Claims claims) {
        this.accountId = claims.get("id", AccountNo.class);
    }

    public LoginUser(AccountNo accountId) {
        this.accountId = accountId;
    }
}

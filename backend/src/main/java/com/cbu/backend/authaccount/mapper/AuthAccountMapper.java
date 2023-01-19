package com.cbu.backend.authaccount.mapper;

import com.cbu.backend.authaccount.command.domain.AuthAccount;

import com.cbu.backend.config.security.oauth2.LoginUser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthAccountMapper {
    public LoginUser mapToLoginUser(AuthAccount user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        return new LoginUser(user.getId(), attributes, user.getRole());
    }
}

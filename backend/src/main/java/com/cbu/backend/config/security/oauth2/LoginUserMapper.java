package com.cbu.backend.config.security.oauth2;

import com.cbu.backend.member.domain.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginUserMapper {
    public LoginUser mapToLoginUser(Member user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        return new LoginUser(user, attributes, user.getRole());
    }
}
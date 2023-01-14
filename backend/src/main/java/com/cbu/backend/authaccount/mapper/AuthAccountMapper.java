package com.cbu.backend.authaccount.mapper;

import com.cbu.backend.authaccount.command.domain.AuthAccount;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthAccountMapper {
    public Map<String, Object> mapToAttributeMap(AuthAccount user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        return attributes;
    }
}

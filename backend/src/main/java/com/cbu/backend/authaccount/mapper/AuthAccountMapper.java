package com.cbu.backend.authaccount.mapper;

import com.cbu.backend.authaccount.entity.AuthAccount;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class AuthAccountMapper {
  public Map<String, Object> mapToAttributeMap(AuthAccount user) {
    Map<String, Object> attributes = new HashMap<>();
    attributes.put("id", user.getId());
    attributes.put("accountId", user.getAccountId());

    return attributes;
  }
}

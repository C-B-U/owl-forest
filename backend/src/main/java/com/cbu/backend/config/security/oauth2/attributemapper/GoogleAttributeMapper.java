package com.cbu.backend.config.security.oauth2.attributemapper;

import com.cbu.backend.authaccount.entity.AuthProvider;
import com.cbu.backend.config.security.oauth2.OAuth2Request;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author Hyeonjun Park
 */
@Component
public class GoogleAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {
    String accountId = (String) attributes.get("sub");
    String name = (String) attributes.get("name");
    String email = (String) attributes.get("email");
    return new OAuth2Request(accountId, name, email, AuthProvider.GOOGLE);
  }
}

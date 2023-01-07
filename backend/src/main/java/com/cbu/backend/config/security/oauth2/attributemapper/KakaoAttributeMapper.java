package com.cbu.backend.config.security.oauth2.attributemapper;

import com.cbu.backend.authaccount.entity.AuthProvider;
import com.cbu.backend.config.security.oauth2.OAuth2Request;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author Hyeonjun Park
 */
@Component
public class KakaoAttributeMapper implements AttributeMappable {
  @Override
  public OAuth2Request mapToDTO(Map<String, Object> attributes) {
    String accountId = ((Integer) attributes.get("id")).toString();
    String email = (String) attributes.get("email");
    String name = "sample";
    return new OAuth2Request(accountId, name, email, AuthProvider.KAKAO);
  }
}
package com.cbu.backend.config.security.oauth2.attributemapper;

import com.cbu.backend.config.security.oauth2.OAuth2Request;

import java.util.Map;

/**
 * 소셜 로그인시 Attribute 값을 dto로 mapping 하는 interface
 *
 * @author Hyeonjun Park
 */
public interface AttributeMappable {
    OAuth2Request mapToDTO(Map<String, Object> attributes);


}

package com.cbu.backend.config.security.oauth2.attributemapper;

import com.cbu.backend.config.security.oauth2.OAuth2Request;
import com.cbu.backend.member.domain.AuthProvider;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * attribute값을 dto로, user을 attribute로 변환해주는 클래스
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class AttributeMapper {

    private final AttributeMapperFactory attributeMapperFactory;

    public OAuth2Request mapToUser(AuthProvider provider, Map<String, Object> attributes) {
        return attributeMapperFactory.get(provider).mapToDTO(attributes);
    }
}

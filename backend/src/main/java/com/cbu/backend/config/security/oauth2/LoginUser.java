package com.cbu.backend.config.security.oauth2;

import com.cbu.backend.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

/**
 * login 유저정보에 대한 dto
 *
 * @author Hyeonjun Park
 */
@Getter
@AllArgsConstructor
public class LoginUser implements UserDetails, OAuth2User {
    private Member member;
    private Map<String, Object> attribute;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getName() {
        return member.getId().toString();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attribute;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getUsername() {
        return member.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

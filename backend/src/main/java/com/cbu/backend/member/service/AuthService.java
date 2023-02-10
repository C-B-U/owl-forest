package com.cbu.backend.member.service;

import com.cbu.backend.config.security.oauth2.LoginUser;
import com.cbu.backend.member.domain.Member;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public Member getLoginUser() {
        return ((LoginUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()))
                .getMember();
    }
}

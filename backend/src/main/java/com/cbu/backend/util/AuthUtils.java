package com.cbu.backend.util;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.config.security.oauth2.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static Member getLoginUser() {
        return ((LoginUser)(SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal()))
                .getMember();
    }
}

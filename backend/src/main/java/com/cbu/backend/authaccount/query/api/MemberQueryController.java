package com.cbu.backend.authaccount.query.api;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.authaccount.command.domain.AuthAccount;
import com.cbu.backend.authaccount.query.service.AuthAccountQueryService;
import com.cbu.backend.config.security.oauth2.LoginUser;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/users/login")
@RequiredArgsConstructor
public class MemberQueryController {
    private final AuthAccountQueryService authAccountQueryService;

    @GetMapping
    public AuthAccount getLoginUser(Principal principal) {
        return authAccountQueryService.getLoginUser(principal);
    }

    @GetMapping("anno")
    public AccountNo getLoginAnno(@AuthenticationPrincipal LoginUser loginUser) {
        return loginUser.getAccountId();
    }

    @GetMapping("lu")
    public AccountNo getLu(LoginUser loginUser) {
        return loginUser.getAccountId();
    }
}

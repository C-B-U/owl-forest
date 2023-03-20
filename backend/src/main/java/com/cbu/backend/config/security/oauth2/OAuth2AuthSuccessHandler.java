package com.cbu.backend.config.security.oauth2;

import com.cbu.backend.config.security.jwt.JwtSetupService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OAuth2 사용지 인증 성공시 진행하는 Handler
 *
 * @author Hyeonjun Park
 */
@Component
public class OAuth2AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtSetupService jwtSetupService;

    private final String clientUrl;
    private final String redirectEndpoint;

    public OAuth2AuthSuccessHandler(
            JwtSetupService jwtSetupService,
            @Value("${client.url}") String clientUrl,
            @Value("${client.endpoint}") String redirectEndpoint) {
        this.jwtSetupService = jwtSetupService;
        this.clientUrl = clientUrl;
        this.redirectEndpoint = redirectEndpoint;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        jwtSetupService.addJwtTokensInCookie(response, loginUser);
        getRedirectStrategy().sendRedirect(request, response, clientUrl + "/" + redirectEndpoint);
    }
}

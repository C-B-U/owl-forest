package com.cbu.backend.member.controller;

import com.cbu.backend.member.service.AuthService.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthTokenController {

    private final AuthService authService; //생성자 주입


//    }
}

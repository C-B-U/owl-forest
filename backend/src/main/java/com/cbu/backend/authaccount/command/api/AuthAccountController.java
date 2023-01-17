package com.cbu.backend.authaccount.command.api;

import com.cbu.backend.authaccount.command.domain.MemberRequest;
import com.cbu.backend.authaccount.command.service.AuthAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class AuthAccountController {
    private final AuthAccountService authAccountService;

    @PutMapping
    public ResponseEntity<Void> putUser(Principal principal, @RequestBody MemberRequest dto) {
        authAccountService.updateMemberInfo(principal, dto);
        return ResponseEntity.noContent().build();
    }
}

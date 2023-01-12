package com.cbu.backend.domain.member.controller;

import com.cbu.backend.domain.authaccount.service.AuthAccountService;
import com.cbu.backend.domain.member.dto.request.CreateMemberRequest;
import com.cbu.backend.domain.member.dto.request.UpdateMemberRequest;
import com.cbu.backend.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final AuthAccountService authAccountService;
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> registerMember(
            Principal principal, @RequestBody CreateMemberRequest dto) {
        authAccountService.registerMember(principal, dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateMember(
            Principal principal, @RequestBody UpdateMemberRequest dto) {
        authAccountService.updateMember(principal, dto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

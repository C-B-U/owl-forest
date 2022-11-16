package com.cbu.backend.member.controller;

import com.cbu.backend.member.dto.request.MemberSignupRequestDTO;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/api/member/")
    public ResponseEntity<MemberResponseDTO> getById(@PathVariable Long id) {
        return null;
    }



    @GetMapping("/api/members")
    public ResponseEntity<List<MemberResponseDTO>> getAll() {
//        return ResponseEntity.ok(MemberService.getAll());
        return null;
    }


    //회원가입
    @PostMapping
    public ResponseEntity<MemberResponseDTO> signup(@RequestBody MemberSignupRequestDTO dto) {
        MemberResponseDTO result = memberService.signup(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }


    @PutMapping("/api/member")
    public ResponseEntity<Void> update(MemberSignupRequestDTO dto) {
//        memberService.update(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        return null;
    }


    @DeleteMapping("/api/member")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        memberService.delete(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        return null;
    }
}

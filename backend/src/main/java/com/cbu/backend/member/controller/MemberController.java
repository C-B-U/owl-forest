package com.cbu.backend.member.controller;

import com.cbu.backend.member.dto.request.MemberLoginRequestDTO;
import com.cbu.backend.member.dto.request.MemberSignupReuestDTO;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
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


    @PostMapping("/api/member")
    public ResponseEntity<Void> signup(@RequestBody MemberLoginRequestDTO dto) {
//        memberService.create(dto);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
        return null;
    }


    @PutMapping("/api/member")
    public ResponseEntity<Void> update(MemberSignupReuestDTO dto) {
//        memberService.update(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        return null;
    }


    @DeleteMapping("/aoi/member")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        memberService.delete(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        return null;
    }
}

package com.cbu.backend.member.controller;
import com.cbu.backend.member.dto.request.MemberSignupRequest;
import com.cbu.backend.member.dto.response.MemberResponse;
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


    @GetMapping("{id}")
    public ResponseEntity<MemberResponse> findById(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not supported yet");
    }



    @GetMapping
    public ResponseEntity<List<MemberResponse>> findAll() {
//        return ResponseEntity.ok(MemberService.getAll());
        throw new UnsupportedOperationException("Not supported yet");
    }


    //회원가입
    @PostMapping
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberSignupRequest dto) {
        MemberResponse result = memberService.signup(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @PutMapping("/api/member")
    public ResponseEntity<Void> update(MemberSignupRequest dto) {
//        memberService.update(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        throw new UnsupportedOperationException("Not supported yet");
    }


    @DeleteMapping("/api/member")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        memberService.delete(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        throw new UnsupportedOperationException("Not supported yet");
    }
}

package com.cbu.backend.member;

import com.cbu.backend.member.dto.UpdateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {
    private final MemberService memberService;

    @PutMapping
    public ResponseEntity<Void> updateMember(@RequestBody UpdateMemberRequest req) {
        memberService.update(req);
        return ResponseEntity.noContent().build();
    }

}

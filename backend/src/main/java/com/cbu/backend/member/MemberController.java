package com.cbu.backend.member;

import com.cbu.backend.member.dto.MemberPrivacyResponse;
import com.cbu.backend.member.dto.MemberResponse;
import com.cbu.backend.member.dto.MemberSummaryResponse;
import com.cbu.backend.member.dto.UpdateMemberRequest;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<MemberSummaryResponse>> getAll(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(memberService.findAll(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(memberService.findById(id));
    }

    @GetMapping("{id}/privacy") //인가 설정 TODO
    public ResponseEntity<MemberPrivacyResponse> getPrivacyById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(memberService.findPrivacyById(id));
    }

}

package com.cbu.backend.member.controller;

import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.member.dto.response.MemberResponse;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(params = "accountId")
    public ResponseEntity<ResponseFormat<MemberResponse>> findByAccountId(@RequestParam String accountId) {
        MemberResponse member = memberService.findByAccountId(accountId);
        ResponseFormat<MemberResponse> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_SUCCESS, member);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "name")
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByName(@RequestParam String name) {

            List<MemberResponse> members = memberService.findByName(name);
            ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

            return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "generation")
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByGeneration(@RequestParam int generation) {

        List<MemberResponse> members = memberService.findByGeneration(generation);
        ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "major")
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByMajor(@RequestParam String major) {

        List<MemberResponse> members = memberService.findByMajor(major);
        ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

        return ResponseEntity.ok(responseFormat);
    }

    @GetMapping(params = "grade")
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByGrade(@RequestParam int grade) {

        List<MemberResponse> members = memberService.findByGrade(grade);
        ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

        return ResponseEntity.ok(responseFormat);
    }
}

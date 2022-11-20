package com.cbu.backend.member.controller;
import com.cbu.backend.article.dto.response.ArticleResponse;
import com.cbu.backend.global.ResponseFormat;
import com.cbu.backend.global.ResponseStatus;
import com.cbu.backend.member.dto.request.MemberSignupRequest;
import com.cbu.backend.member.dto.response.MemberResponse;
import com.cbu.backend.member.entity.Member;
import com.cbu.backend.member.mapper.MemberMapper;
import com.cbu.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public ResponseEntity<ResponseFormat<MemberResponse>> findById(@RequestParam String id) {
        MemberResponse member = memberService.findByAccountId(id);
        ResponseFormat<MemberResponse> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, member);

        return ResponseEntity.ok(responseFormat);
    }


    // findByName -> USER, ADMIN
    @RequestMapping(params = "name", method = RequestMethod.GET)
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByName(@RequestParam String name) {

            List<MemberResponse> members = memberService.findByName(name);
            ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

            return ResponseEntity.ok(responseFormat);
    }

    // findByGeneration -> ADMIN
    @RequestMapping(params = "generation", method = RequestMethod.GET)
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByGeneration(@RequestParam int generation) {

        List<MemberResponse> members = memberService.findByGeneration(generation);
        ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

        return ResponseEntity.ok(responseFormat);
    }

    // findByMajor -> USER, ADMIN
    @RequestMapping(params = "major", method = RequestMethod.GET)
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByMajor(@RequestParam String major) {

        List<MemberResponse> members = memberService.findByMajor(major);
        ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

        return ResponseEntity.ok(responseFormat);
    }


    // findByGrade -> USER, ADMIN
    @RequestMapping(params = "grade", method = RequestMethod.GET)
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> findByGrade(@RequestParam int grade) {

        List<MemberResponse> members = memberService.findByGrade(grade);
        ResponseFormat<List<MemberResponse>> responseFormat = new ResponseFormat<>(ResponseStatus.GET_MEMBER_LIST_SUCCESS, members);

        return ResponseEntity.ok(responseFormat);
    }

    @PostMapping
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberSignupRequest dto) {
        MemberResponse result = memberMapper.toDto(memberService.signup(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    //텍스트 전체 업데이트
    @PutMapping("/api/member")
    public ResponseEntity<Void> update(MemberSignupRequest dto) {
//        memberService.update(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        throw new UnsupportedOperationException("Not supported yet");
    }

    //프로필 사진 업데이트 updateProfilePicture

    //관리자가 member 삭제 - pk가지고 삭제, 관리자권한 체크. admin패키지 밑에 작업
    @DeleteMapping("/api/admin/member")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        memberService.delete(dto);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .build();
        throw new UnsupportedOperationException("Not supported yet");
    }
}

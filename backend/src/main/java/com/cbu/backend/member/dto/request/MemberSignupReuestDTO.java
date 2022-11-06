package com.cbu.backend.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignupReuestDTO {

    private String name;

    private String study;

    private String password;

    private String accountId;

    private String email;

    private int grade;

    private String major;

    private String studentId;

    private String generation; //기수

    private String phoneNumber;

//    private String blogUrl;
//
//    private String githubId;
//
//    private String profileUrl;
//
//    private String introduction;
}

/*
* - id(user_id, PK)  일반,본인,관리자
- accountId 본인,관리자
- 이름 (소셜에서 Null) 일반,본인,관리자
- password(소셜에서 Null)
- email(소셜에서 Null) 일반,본인,관리자
- 학년(소셜에서 Null) 일반,본인,관리자
- 기수(소셜에서 Null) 일반,본인,관리자
- 학과(소셜에서 Null) 일반,본인,관리자
- 학번(소셜에서 Null) 본인,관리자
- 블로그(소셜에서 Null) 일반,본인,관리자
- 깃헙 (소셜에서 Null) 일반,본인,관리자
- 전화번호(소셜에서 Null) 본인,관리자
- 프로필사진(소셜에서 Null) 일반,본인,관리자
- 본인 관심사 태그(소셜에서 Null) 일반,본인,관리자
- 한 줄 소개(소셜에서 Null) 일반,본인,관리자
- 가입된 스터디 (보류)(소셜에서 Null)
* */
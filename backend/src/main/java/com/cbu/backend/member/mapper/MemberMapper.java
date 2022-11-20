package com.cbu.backend.member.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.dto.request.MemberSignupRequest;
import com.cbu.backend.member.dto.response.MemberResponse;
import com.cbu.backend.member.dto.response.MemberView;
import com.cbu.backend.member.entity.Authority;
import com.cbu.backend.member.entity.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@Mapper
@RequiredArgsConstructor
public class MemberMapper {
    private final ObjectMapper objectMapper;

    public String toJsonString(Member member, Class<MemberView> memberViewClass) throws JsonProcessingException {
        return objectMapper.writerWithView(memberViewClass).writeValueAsString(member);
    }

    public MemberResponse toDto(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .grade(member.getGrade())
                .major(member.getMajor())
                .blogUrl(member.getBlogUrl())
                .profileUrl(member.getProfileUrl())
                .studentId(member.getStudentId())
                .githubId(member.getGithubId())
                .interestTags(member.getTags())
                .phoneNumber(member.getPhoneNumber())
                .accountId(member.getAccountId())
                .email(member.getEmail())
                .introduction(member.getIntroduction())
                .name(member.getName())
                .generation(member.getGeneration())
                .build();
    }

    public Member toEntity(MemberSignupRequest dto) {
        Member member = Member.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .accountId(dto.getAccountId())
                .email(dto.getEmail())
                .grade(dto.getGrade())
                .major(dto.getMajor())
                .studentId(dto.getStudentId())
                .generation(dto.getGeneration())
                .blogUrl(dto.getBlogUrl())
                .githubId(dto.getGithubId())
                .profileUrl(dto.getProfileUrl())
                .phoneNumber(dto.getPhoneNumber())
                .introduction(dto.getIntroduction())
                .build();

        member.setAuthority(Authority.USER);
        return member;
    }
}

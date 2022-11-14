package com.cbu.backend.member.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import com.cbu.backend.member.dto.response.MemberView;
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

    public MemberResponseDTO toDto(Member member) {
        return MemberResponseDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .accountId(member.getEmail())
                .email(member.getEmail())
                .grade(member.getGrade())
                .major(member.getMajor())
                .studentId(member.getStudentId())
                .generation(member.getGeneration())
                .blogUrl(member.getBlogUrl())
                .githubId(member.getGithubId())
                .profileUrl(member.getProfileUrl())
                .phoneNumber(member.getPhoneNumber())
                .introduction(member.getIntroduction())
                .build();

    }
}

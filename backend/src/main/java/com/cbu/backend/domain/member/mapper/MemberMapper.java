package com.cbu.backend.domain.member.mapper;

import com.cbu.backend.domain.member.dto.request.CreateMemberRequest;
import com.cbu.backend.domain.member.dto.response.MemberResponse;
import com.cbu.backend.domain.member.dto.response.MemberView;
import com.cbu.backend.domain.member.entity.Member;
import com.cbu.backend.domain.member.entity.MemberDetail;
import com.cbu.backend.domain.member.entity.MemberPrivacy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberMapper {
    private final ObjectMapper objectMapper;

    public String toJsonString(Member member, Class<MemberView> memberViewClass)
            throws JsonProcessingException {
        return objectMapper.writerWithView(memberViewClass).writeValueAsString(member);
    }

    public MemberResponse toDto(Member member) {
        return MemberResponse.builder().build();
    }

    public Member toEntity(CreateMemberRequest dto) {
        return Member.builder()
                .name(dto.getName())
                .memberDetail(toMemberDetail(dto))
                .memberPrivacy(toMemberPrivacy(dto))
                .nickname(dto.getNickname())
                .build();
    }

    private MemberDetail toMemberDetail(CreateMemberRequest dto) {
        return MemberDetail.builder()
                .major(dto.getMajor())
                .subMajor(dto.getSubMajor())
                .blogUrl(dto.getBlogUrl())
                .academicStatus(dto.getAcademicStatus())
                .githubId(dto.getGithubId())
                .email(dto.getEmail())
                .introduction(dto.getIntroduction())
                .build();
    }

    private MemberPrivacy toMemberPrivacy(CreateMemberRequest dto) {
        return MemberPrivacy.builder()
                .phoneNumber(dto.getPhoneNumber())
                .studentId(dto.getStudentId())
                .build();
    }

    public List<MemberResponse> toDtoList(List<Member> list) {
        return list.stream().map(this::toDto).collect(Collectors.toList());
    }
}

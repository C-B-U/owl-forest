package com.cbu.backend.member.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.dto.request.MemberSignupRequestDTO;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import com.cbu.backend.member.dto.response.MemberView;
import com.cbu.backend.member.entity.Authority;
import com.cbu.backend.member.entity.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

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
                .accountId(member.getAccountId())
                .email(member.getEmail())
                .name(member.getName())
                .generation(member.getGeneration())
                .build();

    }

    public Member toEntity(MemberSignupRequestDTO dto, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .name(dto.getName())
                .password(passwordEncoder.encode(dto.getPassword()))
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

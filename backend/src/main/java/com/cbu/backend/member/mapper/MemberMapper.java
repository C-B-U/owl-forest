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

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@RequiredArgsConstructor
public class MemberMapper {
    private final ObjectMapper objectMapper;

    public String toJsonString(Member member, Class<MemberView> memberViewClass) throws JsonProcessingException {
        return objectMapper.writerWithView(memberViewClass).writeValueAsString(member);
    }

    public MemberResponse toDto(Member member) {
        return MemberResponse.builder()
                .build();
    }

    public Member toEntity(MemberSignupRequest dto) {
        return Member.builder()
                .build();
    }

    public List<MemberResponse> toDtoList(List<Member> list) {
        return list.stream().map(this::toDto)
                .collect(Collectors.toList());
    }
}

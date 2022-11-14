package com.cbu.backend.member.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.dto.response.MemberResponse;
import com.cbu.backend.member.entity.Member;

@Mapper
public class MemberMapper {
    public MemberResponse toDto(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .build();
    }
}

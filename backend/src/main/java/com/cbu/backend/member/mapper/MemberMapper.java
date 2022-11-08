package com.cbu.backend.member.mapper;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.dto.response.MemberResponseDTO;
import com.cbu.backend.member.entity.Member;

@Mapper
public class MemberMapper {
    public MemberResponseDTO toDto(Member member) {
        return MemberResponseDTO.builder()
                .id(member.getId())
                .build();
    }
}

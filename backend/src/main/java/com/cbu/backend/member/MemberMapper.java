package com.cbu.backend.member;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.dto.UpdateMemberRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    void updateFromDto(UpdateMemberRequest dto, @MappingTarget Member member);
}

package com.cbu.backend.member;

import com.cbu.backend.global.Mapper;
import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.dto.UpdateMemberRequest;
import org.mapstruct.MappingTarget;

@Mapper
public interface MemberMapper {
    void updateFromDto(UpdateMemberRequest dto, @MappingTarget Member member);
}

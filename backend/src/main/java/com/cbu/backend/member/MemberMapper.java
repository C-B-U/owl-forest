package com.cbu.backend.member;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.member.dto.MemberPrivacyResponse;
import com.cbu.backend.member.dto.MemberResponse;
import com.cbu.backend.member.dto.MemberSummaryResponse;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    MemberPrivacyResponse toPrivacyDto(Member member);

    MemberResponse toDto(Member member);

    MemberSummaryResponse toSummaryDto(Member member);
}

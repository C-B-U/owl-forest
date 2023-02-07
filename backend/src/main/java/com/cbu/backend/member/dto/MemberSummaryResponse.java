package com.cbu.backend.member.dto;

import com.cbu.backend.member.domain.Major;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class MemberSummaryResponse {
    private UUID id;
    private String name;
    private Integer grade;
    private Major major;
    // 관심분야 추가 TODO
}

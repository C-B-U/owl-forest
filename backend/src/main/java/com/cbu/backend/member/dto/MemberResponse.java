package com.cbu.backend.member.dto;

import com.cbu.backend.member.domain.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponse {
    private UUID id;
    private String name;
    private Integer grade;
    private Major major;
    private String email;
    private String blogUrl;
    private String githubId;
    private String introduction;
    private String studentId;
    private String phoneNumber;
}

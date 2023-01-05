package com.cbu.backend.studygroup.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupMemberResponse {
    private Long id;
    private String name;
    private String major;
    private Integer grade;
    private String profileUrl;
}
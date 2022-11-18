package com.cbu.backend.studyplan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudyPlanResponse {
    private Long id;
    private String title;
    private String generationNum;
    private String rule;
    private String teamMember;
    private String book;
    private String studyGroupId;
}

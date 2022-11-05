package com.cbu.backend.studyPlan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudyPlanRequestDTO {
    private String title;
    private String generationNum;
    private String rule;
    private String teamMember;
    private String book;
    private String studyGroupId;
}

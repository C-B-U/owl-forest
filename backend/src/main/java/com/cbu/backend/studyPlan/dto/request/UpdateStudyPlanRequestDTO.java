package com.cbu.backend.studyPlan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudyPlanRequestDTO {
    private String title;
    private String generationNum;
    private String rule;
    private String teamMember;
    private String book;
}

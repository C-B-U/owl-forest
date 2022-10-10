package com.cbu.backend.studyPlan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class StudyPlanResponseDTO {
    private Long id;
    private String title;
    private String generationNum;
    private String rule;
    private String teamMember;
    private String book;
}

package com.cbu.backend.studyPlan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data

public class StudyPlanResponseDTO {
    private Long id;
    private String title;
    private String generationNum;
    private String rule;
    private String teamMember;
    private String book;
    private String studyGroupId;
}

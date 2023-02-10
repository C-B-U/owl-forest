package com.cbu.backend.studyplan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlanResponse {
    private Long id;
    private String title;
    private String studyRule;
    private String weekPlan;
}

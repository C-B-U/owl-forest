package com.cbu.backend.studyplan.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlanRequest {
    @NotBlank
    private String title;
    private String studyRule;
    private String weekPlan;
}

package com.cbu.backend.studyplan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 스터디 계획서 응답 DTO
 *
 * @author ohksj77(김승진)
 */
@Getter
@Builder
@AllArgsConstructor
public class StudyPlanResponse {
    private Long id;
    private String title;
    private Integer generation;
    private String rule;
    private String book;
    private Long studyGroupId;
    private List<WeekPlanResponse> weekPlans = new ArrayList<>();
}

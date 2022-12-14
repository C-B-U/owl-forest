package com.cbu.backend.studyplan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 스터디 계획서 주별 계획 응답 DTO
 *
 * @author ohksj77(김승진)
 */
@Getter
@Builder
@AllArgsConstructor
public class WeekPlanResponse {
    private Long id;
    private Integer week;
    private LocalDate studyDate;
    private String contents;
}

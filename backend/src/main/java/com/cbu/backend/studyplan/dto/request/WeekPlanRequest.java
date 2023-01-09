package com.cbu.backend.studyplan.dto.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 스터디 계획서 주별 계획 요청 DTO
 *
 * @author ohksj77(김승진)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeekPlanRequest {
  private Integer week;
  private LocalDate studyDate;
  private String contents;
}

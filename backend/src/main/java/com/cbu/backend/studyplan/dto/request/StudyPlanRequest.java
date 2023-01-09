package com.cbu.backend.studyplan.dto.request;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 스터디 계획서 요청 DTO
 *
 * @author ohksj77(김승진)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlanRequest {
  private String title;
  private Integer generation;
  private String rule;
  private List<WeekPlanRequest> weekPlans = new ArrayList<>();
}

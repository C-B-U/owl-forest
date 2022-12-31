package com.cbu.backend.studyplan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlanRequest {
  private String title;
  private String generationNum;
  private String rule;
  private String teamMember;
  private String book;
  private String studyGroupId;
}

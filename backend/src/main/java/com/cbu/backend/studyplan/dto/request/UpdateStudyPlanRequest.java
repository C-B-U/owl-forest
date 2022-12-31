package com.cbu.backend.studyplan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudyPlanRequest {
  private String title;
  private String generationNum;
  private String rule;
  private String teamMember;
  private String book;
}

package com.cbu.backend.studyactivitylog.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyActivityLogRequest {
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private String place;
  private List<Long> teamMembers;
  private String title;
  private String description;
  private String assignment;
}

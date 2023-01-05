package com.cbu.backend.studygroup.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 스터디 그룹과 멤버의 M대N 관계에서 나오는 엔티티에 대한 Response DTO
 *
 * @author ohksj(김승진)
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupMemberResponse {
  private Long id;
  private String name;
  private String major;
  private Integer grade;
  private String profileUrl;
}

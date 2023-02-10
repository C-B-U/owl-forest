package com.cbu.backend.studyactivity.dto;

import com.cbu.backend.studyactivity.StudyTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyActivityResponse {
    private String title;
    private String description;
    private String assignment;
    private Integer week;
    private String place;
    private StudyTime studyTime;
    private Set<ActivityMemberResponse> activityMembers;
}

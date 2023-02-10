package com.cbu.backend.studygroup.dto;

import com.cbu.backend.studygroup.StudyGroupStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupResponse {
    private String name;
    private String description;
    private Integer likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyMemberResponse leader;
    private Set<StudyMemberResponse> members;
}

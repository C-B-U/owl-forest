package com.cbu.backend.studygroup.dto;

import com.cbu.backend.studygroup.StudyGroupStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupResponse {
    private String name;
    private String description;
    private Integer likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyGroupResponse leader;
    private List<StudyGroupResponse> members;
}

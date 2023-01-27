package com.cbu.backend.studygroup.query.dto;

import com.cbu.backend.studygroup.command.domain.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyGroupResponse {
    private StudyGroupNo id;
    private String name;
    private String description;
    private LikeCount likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyGroupMember studyGroupMember;

    public StudyGroupResponse(StudyGroup studyGroup) {
        this.id = studyGroup.getId();
        this.name = studyGroup.getName();
        this.description = studyGroup.getDescription();
        this.likeCount = studyGroup.getLikeCount();
        this.studyGroupStatus = studyGroup.getStudyGroupStatus();
        this.studyGroupMember = studyGroup.getStudyGroupMember();
    }
}

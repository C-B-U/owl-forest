package com.cbu.backend.studygroup.query.dto;

import com.cbu.backend.studygroup.command.domain.StudyGroupStatus;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class StudyGroupDetailResponse {
    private UUID id;
    private String name;
    private String description;
    private Integer likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyMember studyLeader;
    private List<StudyMember> participants;

    public StudyGroupDetailResponse(StudyGroupResponse studyGroup, List<StudyMember> participants) {
        this.id = studyGroup.getId();
        this.name = studyGroup.getName();
        this.description = studyGroup.getDescription();
        this.likeCount = studyGroup.getLikeCount();
        this.studyGroupStatus = studyGroup.getStudyGroupStatus();
        this.studyLeader = studyGroup.getStudyLeader();
        this.participants = participants;
    }
}

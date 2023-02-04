package com.cbu.backend.studygroup.query.dto;

import com.cbu.backend.studygroup.command.domain.StudyGroupStatus;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

import java.util.UUID;

@Getter
public class StudyGroupResponse {
    private UUID id;
    private String name;
    private String description;
    private Integer likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyMember studyLeader;

    @QueryProjection
    public StudyGroupResponse(
            UUID id,
            String name,
            String description,
            Integer likeCount,
            StudyGroupStatus studyGroupStatus,
            StudyMember studyLeader) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.studyGroupStatus = studyGroupStatus;
        this.studyLeader = studyLeader;
    }
}

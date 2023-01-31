package com.cbu.backend.studygroup.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

import java.util.UUID;

@Getter
public class StudyGroupInfo {
    private UUID id;
    private String name;
    private String description;
    private Integer likeCount;
    private String studyGroupStatus;
    private StudyMemberInfo studyLeader;

    @QueryProjection
    public StudyGroupInfo(
            UUID id,
            String name,
            String description,
            Integer likeCount,
            String studyGroupStatus,
            StudyMemberInfo studyLeader) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.studyGroupStatus = studyGroupStatus;
        this.studyLeader = studyLeader;
    }
}

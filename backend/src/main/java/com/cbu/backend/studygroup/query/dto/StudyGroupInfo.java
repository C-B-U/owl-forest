package com.cbu.backend.studygroup.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
public class StudyGroupInfo {
    private UUID id;
    private String name;
    private String description;
    private Integer likeCount;
    private String studyGroupStatus;
    @QueryProjection
    public StudyGroupInfo(
            UUID id,
            String name,
            String description,
            Integer likeCount,
            String studyGroupStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.studyGroupStatus = studyGroupStatus;
    }
}

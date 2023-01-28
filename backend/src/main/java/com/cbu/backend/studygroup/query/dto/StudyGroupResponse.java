package com.cbu.backend.studygroup.query.dto;

import com.cbu.backend.studygroup.command.domain.*;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class StudyGroupResponse {
    private StudyGroupNo id;
    private String name;
    private String description;
    private Integer likeCount;
    private String studyGroupStatus;
    private StudyMember studyMember;

    @QueryProjection
    public StudyGroupResponse(StudyGroupNo id, String name, String description, Integer likeCount, String studyGroupStatus, StudyMember studyMember) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.studyGroupStatus = studyGroupStatus;
        this.studyMember = studyMember;
    }
}

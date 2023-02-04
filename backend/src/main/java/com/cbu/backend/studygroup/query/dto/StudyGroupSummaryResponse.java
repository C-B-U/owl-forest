package com.cbu.backend.studygroup.query.dto;

import com.cbu.backend.studygroup.command.domain.StudyGroupStatus;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class StudyGroupSummaryResponse {
    private UUID id;
    private String name;
    private String description;
    private Integer likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyMember studyLeader;
    private List<StudyMember> participants;

    @QueryProjection
    public StudyGroupSummaryResponse(UUID id, String name, String description, Integer likeCount, StudyGroupStatus studyGroupStatus, StudyMember studyLeader) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.studyGroupStatus = studyGroupStatus;
        this.studyLeader = studyLeader;
    }
}

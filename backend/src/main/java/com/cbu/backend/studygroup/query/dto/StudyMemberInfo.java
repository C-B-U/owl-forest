package com.cbu.backend.studygroup.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
public class StudyMemberInfo {
    private UUID id;
    private String name;

    @QueryProjection
    public StudyMemberInfo(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}

package com.cbu.backend.studygroup.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

import java.util.UUID;

@Getter
public class StudyMember {
    private UUID id;
    private String name;

    @QueryProjection
    public StudyMember(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}

package com.cbu.backend.studygroup.query.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;

@Getter
public class StudyMemberInfo {
    private AccountNo id;
    private String name;

    @QueryProjection
    public StudyMemberInfo(AccountNo id, String name) {
        this.id = id;
        this.name = name;
    }
}

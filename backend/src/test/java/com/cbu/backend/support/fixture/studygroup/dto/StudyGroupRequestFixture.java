package com.cbu.backend.support.fixture.studygroup.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studygroup.dto.StudyGroupRequest;

import java.util.List;

public enum StudyGroupRequestFixture {
    SAMPLE1(
            "봄나물",
            "스프링 기초 스터디 핵심원리편",
            new AccountNo(),
            List.of(new AccountNo(), new AccountNo(), new AccountNo(), new AccountNo())),

    SAMPLE2(
            "봄바스틱",
            "스프링 기초 스터디 MVC편",
            new AccountNo(),
            List.of(new AccountNo(), new AccountNo(), new AccountNo(), new AccountNo()));

    private final String name;
    private final String description;
    private final AccountNo leader;
    private final List<AccountNo> participants;

    StudyGroupRequestFixture(
            String name, String description, AccountNo leader, List<AccountNo> participants) {
        this.name = name;
        this.description = description;
        this.leader = leader;
        this.participants = participants;
    }

    public StudyGroupRequest toStudyGroupRequest() {
        return new StudyGroupRequest(name, description, leader, participants);
    }
}

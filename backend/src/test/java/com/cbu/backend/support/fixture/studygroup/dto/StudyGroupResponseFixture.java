package com.cbu.backend.support.fixture.studygroup.dto;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.studygroup.command.domain.StudyGroupStatus;
import com.cbu.backend.studygroup.query.dto.StudyGroupInfo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.dto.StudyMemberInfo;

import java.util.List;
import java.util.UUID;

public enum StudyGroupResponseFixture {
    SAMPLE1(
            new StudyGroupInfo(
                    UUID.randomUUID(),
                    "봄나물",
                    "스프링 기초 스터디 핵심원리편",
                    10000,
                    StudyGroupStatus.FINISHED.toString()),
            new StudyMemberInfo(new AccountNo().getId(), "Park"),
            List.of(
                    new StudyMemberInfo(new AccountNo().getId(), "Kim"),
                    new StudyMemberInfo(new AccountNo().getId(), "Lee"),
                    new StudyMemberInfo(new AccountNo().getId(), "Park"),
                    new StudyMemberInfo(new AccountNo().getId(), "Choi"))),
    SAMPLE2(
            new StudyGroupInfo(
                    UUID.randomUUID(),
                    "봄바스틱",
                    "스프링 기초 스터디 MVC편",
                    10000,
                    StudyGroupStatus.FINISHED.toString()),
            new StudyMemberInfo(new AccountNo().getId(), "Kim"),
            List.of(
                    new StudyMemberInfo(new AccountNo().getId(), "Kim"),
                    new StudyMemberInfo(new AccountNo().getId(), "Kim"),
                    new StudyMemberInfo(new AccountNo().getId(), "Kim"),
                    new StudyMemberInfo(new AccountNo().getId(), "Kim")));

    private StudyGroupInfo studyGroupInfo;
    private StudyMemberInfo studyLeader;
    private List<StudyMemberInfo> participants;

    StudyGroupResponseFixture(StudyGroupInfo studyGroupInfo, StudyMemberInfo studyLeader, List<StudyMemberInfo> participants) {
        this.studyGroupInfo = studyGroupInfo;
        this.studyLeader = studyLeader;
        this.participants = participants;
    }

    public StudyGroupResponse toStudyGroupResponse() {
        return new StudyGroupResponse(studyGroupInfo, studyLeader, participants);
    }
}

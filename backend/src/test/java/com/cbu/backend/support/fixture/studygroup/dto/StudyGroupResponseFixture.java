package com.cbu.backend.support.fixture.studygroup.dto;

import com.cbu.backend.studygroup.StudyGroupStatus;
import com.cbu.backend.studygroup.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.dto.StudyMemberResponse;

import java.util.Set;
import java.util.UUID;

public enum StudyGroupResponseFixture {

    SAMPLE1(
            "자바칩 스터디",
            "자바칩 정복 스터디입니다",
            100,
            StudyGroupStatus.ACTIVE,
            new StudyMemberResponse(UUID.randomUUID(), "리더"),
            Set.of(new StudyMemberResponse(UUID.randomUUID(), "멤버1"), new StudyMemberResponse(UUID.randomUUID(), "멤버2"))
    );
    private String name;
    private String description;
    private Integer likeCount;
    private StudyGroupStatus studyGroupStatus;
    private StudyMemberResponse leader;
    private Set<StudyMemberResponse> members;

    StudyGroupResponseFixture(String name, String description, Integer likeCount, StudyGroupStatus studyGroupStatus, StudyMemberResponse leader, Set<StudyMemberResponse> members) {
        this.name = name;
        this.description = description;
        this.likeCount = likeCount;
        this.studyGroupStatus = studyGroupStatus;
        this.leader = leader;
        this.members = members;
    }

    public StudyGroupResponse toStudyGroupResponse() {
        return new StudyGroupResponse(name, description, likeCount, studyGroupStatus, leader, members);
    }
}

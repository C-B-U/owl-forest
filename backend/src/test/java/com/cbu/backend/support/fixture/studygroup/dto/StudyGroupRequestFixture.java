package com.cbu.backend.support.fixture.studygroup.dto;


import com.cbu.backend.studygroup.dto.StudyGroupRequest;

import java.util.List;
import java.util.UUID;

public enum StudyGroupRequestFixture {
    SAMPLE1(
            "봄나물",
            "스프링 기초 스터디 핵심원리편",
            UUID.randomUUID(),
            List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID())),

    SAMPLE2(
            "봄바스틱",
            "스프링 기초 스터디 MVC편",
            UUID.randomUUID(),
            List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));

    private final String name;
    private final String description;
    private final UUID leader;
    private final List<UUID> participants;

    StudyGroupRequestFixture(
            String name, String description, UUID leader, List<UUID> participants) {
        this.name = name;
        this.description = description;
        this.leader = leader;
        this.participants = participants;
    }

    public StudyGroupRequest toStudyGroupRequest() {
        return new StudyGroupRequest(name, description, leader, participants);
    }
}


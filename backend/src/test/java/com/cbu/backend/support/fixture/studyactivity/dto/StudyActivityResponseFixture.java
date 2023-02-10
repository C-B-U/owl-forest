package com.cbu.backend.support.fixture.studyactivity.dto;

import com.cbu.backend.studyactivity.dto.ActivityMemberResponse;
import com.cbu.backend.studyactivity.dto.StudyActivityResponse;

import java.util.Set;
import java.util.UUID;

public enum StudyActivityResponseFixture {
    SAMPLE1(
            "k8s 스터디",
            "K8S아니고 KBS",
            "과제1",
            4,
            "종합관 2층 스터디룸",
            Set.of(
                    new ActivityMemberResponse(UUID.randomUUID(), "Kim"),
                    new ActivityMemberResponse(UUID.randomUUID(), "Lee"))),
    SAMPLE2(
            "리액트 스터디",
            "React.js",
            "타입스크립트 조사해오기",
            1,
            "E동2층",
            Set.of(
                    new ActivityMemberResponse(UUID.randomUUID(), "Park"),
                    new ActivityMemberResponse(UUID.randomUUID(), "Hong")));

    private String title;
    private String description;
    private String assignment;
    private Integer week;
    private String place;
    private Set<ActivityMemberResponse> activityMembers;

    StudyActivityResponseFixture(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            Set<ActivityMemberResponse> activityMembers) {
        this.title = title;
        this.description = description;
        this.assignment = assignment;
        this.week = week;
        this.place = place;
        this.activityMembers = activityMembers;
    }

    public StudyActivityResponse toStudyActivityResponse() {
        return new StudyActivityResponse(
                title, description, assignment, week, place, activityMembers);
    }
}

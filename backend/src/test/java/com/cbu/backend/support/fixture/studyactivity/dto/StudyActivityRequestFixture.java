package com.cbu.backend.support.fixture.studyactivity.dto;

import com.cbu.backend.studyactivity.StudyTime;
import com.cbu.backend.studyactivity.dto.StudyActivityRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public enum StudyActivityRequestFixture {
    SAMPLE1(
            "자바 스터디 1일차",
            "자바 기본 문법",
            "1단원 연습 문제",
            1,
            "보보스 1호점",
            List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()),
            1L,
            new StudyTime(
                    LocalDateTime.now().minusHours(2).withNano(0),
                    LocalDateTime.now().withNano(0)));
    private String title;
    private String description;
    private String assignment;
    private Integer week;
    private String place;
    private List<UUID> activityMembers;
    private Long studyGroupId;
    private StudyTime studyTime;

    StudyActivityRequestFixture(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            List<UUID> activityMembers,
            Long studyGroupId,
            StudyTime studyTime) {
        this.title = title;
        this.description = description;
        this.assignment = assignment;
        this.week = week;
        this.place = place;
        this.activityMembers = activityMembers;
        this.studyGroupId = studyGroupId;
        this.studyTime = studyTime;
    }

    public StudyActivityRequest tostudyActivityRequest() {
        return new StudyActivityRequest(
                title,
                description,
                assignment,
                week,
                place,
                activityMembers,
                studyGroupId,
                studyTime);
    }
}

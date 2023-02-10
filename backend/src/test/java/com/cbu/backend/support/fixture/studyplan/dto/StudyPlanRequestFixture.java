package com.cbu.backend.support.fixture.studyplan.dto;

import com.cbu.backend.studyplan.dto.StudyPlanRequest;

public enum StudyPlanRequestFixture {
    SAMPLE1("스프링가링가링 스터디 계획서", "튀면 벌금 50000원", "1 ~ 10주차 스프링 공부", 1L);
    private String title;
    private String studyRule;
    private String weekPlan;
    private Long studyGroupId;

    StudyPlanRequestFixture(String title, String studyRule, String weekPlan, Long studyGroupId) {
        this.title = title;
        this.studyRule = studyRule;
        this.weekPlan = weekPlan;
        this.studyGroupId = studyGroupId;
    }

    public StudyPlanRequest toStudyPlanRequest() {
        return new StudyPlanRequest(title, studyRule, weekPlan, studyGroupId);
    }
}

package com.cbu.backend.support.fixture.studyplan.dto;

import com.cbu.backend.studyplan.dto.StudyPlanRequest;

public enum StudyPlanRequestFixture {
    SAMPLE1("스프링가링가링 스터디 계획서", "튀면 벌금 50000원", "1 ~ 10주차 스프링 공부");
    private String title;
    private String studyRule;
    private String weekPlan;

    StudyPlanRequestFixture(String title, String studyRule, String weekPlan) {
        this.title = title;
        this.studyRule = studyRule;
        this.weekPlan = weekPlan;
    }

    public StudyPlanRequest toStudyPlanRequest() {
        return new StudyPlanRequest(title, studyRule, weekPlan);
    }
}

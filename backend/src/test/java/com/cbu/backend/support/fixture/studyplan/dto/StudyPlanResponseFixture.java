package com.cbu.backend.support.fixture.studyplan.dto;

import com.cbu.backend.studyplan.dto.StudyPlanResponse;

public enum StudyPlanResponseFixture {
    SAMPLE1(1L, "자바 스터디 계획서", "매주 과제 열심히 안해올 시 커피 쏘기", "1 ~ 12주차 자바 공부");
    private Long id;
    private String title;
    private String studyRule;
    private String weekPlan;

    StudyPlanResponseFixture(Long id, String title, String studyRule, String weekPlan) {
        this.id = id;
        this.title = title;
        this.studyRule = studyRule;
        this.weekPlan = weekPlan;
    }

    public StudyPlanResponse toStudyPlanResponse() {
        return new StudyPlanResponse(id, title, studyRule, weekPlan);
    }
}

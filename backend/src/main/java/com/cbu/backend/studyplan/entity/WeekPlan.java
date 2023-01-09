package com.cbu.backend.studyplan.entity;

import lombok.*;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * 스터디 계획서 주별 계획 엔티티
 *
 * @author ohksj77(김승진)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeekPlan {

    @Id @GeneratedValue private Long id;

    private Integer week;

    private LocalDate studyDate;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_plan_id")
    private StudyPlan studyPlan;

    @Builder
    public WeekPlan(Integer week, LocalDate studyDate, String contents, StudyPlan studyPlan) {
        this.week = week;
        this.studyDate = studyDate;
        this.contents = contents;
        this.studyPlan = studyPlan;
    }

    public void registerWeekPlan(StudyPlan studyPlan) {
        this.studyPlan = studyPlan;
        studyPlan.getWeekPlans().add(this);
    }
}

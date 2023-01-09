package com.cbu.backend.studyplan.entity;

import com.cbu.backend.global.BaseTime;
import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 스터디 계획서 엔티티
 *
 * @author ohksj77(김승진)
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyPlan {

    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String title;

    //스터디 규칙
    @Lob
    private String rule;

    @Embedded private BaseTime baseTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @OneToMany(mappedBy = "studyPlan", fetch = FetchType.LAZY)
    private List<WeekPlan> weekPlans = new ArrayList<>();

    @Builder
    public StudyPlan(
            String title,
            String rule,
            BaseTime baseTime,
            StudyGroup studyGroup,
            List<WeekPlan> weekPlans) {
        this.title = title;
        this.rule = rule;
        this.baseTime = baseTime;
        this.studyGroup = studyGroup;
        this.weekPlans = weekPlans;
        baseTime = new BaseTime();
    }

    public void update(StudyPlanRequest dto) {
        this.title = dto.getTitle();
        this.rule = dto.getRule();
    }
}

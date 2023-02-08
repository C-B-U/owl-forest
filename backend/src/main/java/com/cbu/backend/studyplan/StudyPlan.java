package com.cbu.backend.studyplan;

import com.cbu.backend.global.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyPlan {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String studyRule;
    @Lob
    private String weekPlan;
    @Embedded
    private BaseTime baseTime;


    @Builder
    public StudyPlan(String title, String studyRule, String weekPlan) {
        this.title = title;
        this.studyRule = studyRule;
        this.weekPlan = weekPlan;
        this.baseTime = new BaseTime();
    }

    public void update(String title, String studyRule, String weekPlan) {
        this.title = title;
        this.studyRule = studyRule;
        this.weekPlan = weekPlan;
    }

    public void delete() {
        this.baseTime.delete();
    }
}

package com.cbu.backend.studyplan;

import com.cbu.backend.config.audit.AuditListener;
import com.cbu.backend.config.audit.Auditable;
import com.cbu.backend.global.BaseTime;

import lombok.*;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyPlan implements Auditable {
    @Id @GeneratedValue private Long id;
    private String title;
    @Lob private String studyRule;
    @Lob private String weekPlan;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    private Long studyGroupId;

    @Builder
    public StudyPlan(String title, String studyRule, String weekPlan, Long studyGroupId) {
        this.title = title;
        this.studyRule = studyRule;
        this.weekPlan = weekPlan;
        this.studyGroupId = studyGroupId;
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

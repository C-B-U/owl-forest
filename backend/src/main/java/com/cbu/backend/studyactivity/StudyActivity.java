package com.cbu.backend.studyactivity;

import com.cbu.backend.global.audit.AuditListener;
import com.cbu.backend.global.audit.Auditable;
import com.cbu.backend.global.audit.BaseTime;
import com.cbu.backend.global.audit.SoftDeleteSupport;
import com.cbu.backend.studygroup.StudyMember;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Getter
@Entity
@SoftDeleteSupport
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyActivity implements Auditable {
    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String title;

    @Lob private String description;
    private String assignment;
    private Integer week;
    private String place;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<StudyMember> activityMembers = new HashSet<>();

    private Long studyGroupId;
    @Embedded private StudyTime studyTime;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public StudyActivity(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            Set<StudyMember> activityMembers,
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

    public void update(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            Set<StudyMember> activityMembers,
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

    public void delete() {
        this.baseTime.delete();
    }
}

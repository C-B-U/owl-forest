package com.cbu.backend.studyactivity;

import com.cbu.backend.global.BaseTime;

import com.cbu.backend.member.domain.Member;
import com.cbu.backend.studygroup.StudyGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyActivity {
    @Id @GeneratedValue private Long id;
    @Column(nullable = false)
    private String title;
    @Lob private String description;
    private String assignment;
    private Integer week;
    private String place;
    @OneToMany
    private Set<Member> studyParticipants = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;
    @Embedded private StudyTime studyTime;
    @Embedded private BaseTime baseTime;

    @Builder
    public StudyActivity(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            List<Member> studyParticipants,
            StudyTime studyTime) {
        this.title = title;
        this.description = description;
        this.assignment = assignment;
        this.week = week;
        this.place = place;
        organizeParticipants(studyParticipants);
        this.studyTime = studyTime;
        this.baseTime = new BaseTime();
    }

    public void updateStudyActivity(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            List<Member> studyParticipants,
            StudyTime studyTime) {
        this.title = title;
        this.description = description;
        this.assignment = assignment;
        this.week = week;
        this.place = place;
        clearParticipants();
        organizeParticipants(studyParticipants);
        this.studyTime = studyTime;
    }

    public void deleteStudyActivity() {
        this.baseTime.delete();
    }

    private void organizeParticipants(List<Member> studyParticipants) {
        this.studyParticipants.addAll(studyParticipants);
    }

    private void clearParticipants() {
        this.studyParticipants.clear();
    }
}

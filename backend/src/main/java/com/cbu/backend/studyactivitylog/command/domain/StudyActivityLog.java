package com.cbu.backend.studyactivitylog.command.domain;

import com.cbu.backend.authaccount.command.domain.AccountNo;
import com.cbu.backend.global.BaseTime;

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
public class StudyActivityLog {

    @EmbeddedId private StudyActivityLogNo id;

    @Column(nullable = false)
    private String title;

    @Lob private String description;

    private String assignment;
    private Integer week;

    private String place;

    @ElementCollection
    @CollectionTable(
            name = "study_participants",
            joinColumns = @JoinColumn(name = "study_activity_log_id"))
    private Set<AccountNo> studyParticipants = new HashSet<>();

    @Embedded private StudyTime studyTime;

    @Embedded private BaseTime baseTime;

    @Builder
    public StudyActivityLog(
            String title,
            String description,
            String assignment,
            Integer week,
            String place,
            List<AccountNo> studyParticipants,
            StudyTime studyTime) {
        this.id = new StudyActivityLogNo();
        this.title = title;
        this.description = description;
        this.assignment = assignment;
        this.week = week;
        this.place = place;
        this.studyParticipants.addAll(studyParticipants);
        this.studyTime = studyTime;
        this.baseTime = new BaseTime();
    }

    public void update(String title, String description,
                       String assignment, Integer week,
                       String place, List<AccountNo> studyParticipants,
                       StudyTime studyTime) {
        this.title = title;
        this.description = description;
        this.assignment = assignment;
        this.week = week;
        this.place = place;
        clearParticipants();
        this.studyParticipants.addAll(studyParticipants);
        this.studyTime = studyTime;
    }

    public void delete() {
        this.baseTime.delete();
    }

    private void clearParticipants() {
        this.studyParticipants.clear();
    }
}

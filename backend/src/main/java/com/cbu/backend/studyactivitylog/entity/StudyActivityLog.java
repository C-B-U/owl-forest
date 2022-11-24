package com.cbu.backend.studyactivitylog.entity;

import com.cbu.backend.studygroup.entity.StudyGroup;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyActivityLog {

    @Id
    @GeneratedValue
    private Long id;
    private Integer week;
    @Setter
    private LocalDateTime startTime;
    @Setter
    private LocalDateTime endTime;
    @Setter
    private String place;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studyActivityLog")
    @Setter
    private List<StudyParticipant> teamMembers = new ArrayList<>();
    @Setter
    private String title;
    @Setter
    private String description;
    @Setter
    private String assignment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Builder
    public StudyActivityLog(LocalDateTime startTime, LocalDateTime endTime, String place, String title, String description, String assignment) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.title = title;
        this.description = description;
        this.assignment = assignment;
    }
}

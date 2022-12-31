package com.cbu.backend.studyactivitylog.entity;

import com.cbu.backend.global.BaseTime;
import com.cbu.backend.studygroup.entity.StudyGroup;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyActivityLog {

  @Id @GeneratedValue private Long id;
  private Integer week;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private String place;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "studyActivityLog")
  private List<StudyParticipant> teamMembers = new ArrayList<>();

  private String title;
  private String description;
  private String assignment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "study_group_id")
  private StudyGroup studyGroup;

  @Embedded private BaseTime baseTime;

  @Builder
  public StudyActivityLog(
      LocalDateTime startTime,
      LocalDateTime endTime,
      String place,
      String title,
      String description,
      String assignment) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.place = place;
    this.title = title;
    this.description = description;
    this.assignment = assignment;
  }
}

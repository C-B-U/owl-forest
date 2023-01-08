package com.cbu.backend.studyplan.entity;

import com.cbu.backend.global.BaseTime;
import javax.persistence.*;

import com.cbu.backend.studygroup.entity.StudyGroup;
import com.cbu.backend.studyplan.dto.request.StudyPlanRequest;
import lombok.*;

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

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  private Integer generation;

  private String rule;

  @Embedded private BaseTime baseTime;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "study_group_id")
  private StudyGroup studyGroup;

  @OneToMany(mappedBy = "studyPlan",fetch = FetchType.LAZY)
  private List<WeekPlan> weekPlans = new ArrayList<>();

  @Builder
  public StudyPlan(String title, Integer generation, String rule, BaseTime baseTime, StudyGroup studyGroup, List<WeekPlan> weekPlans) {
    this.title = title;
    this.generation = generation;
    this.rule = rule;
    this.baseTime = baseTime;
    this.studyGroup = studyGroup;
    this.weekPlans = weekPlans;
  }

  public void update(StudyPlanRequest dto) {
    this.title = dto.getTitle();
    this.generation = dto.getGeneration();
    this.rule = dto.getRule();
  }
}

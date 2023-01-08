package com.cbu.backend.studyplan.repository;

import com.cbu.backend.studyplan.entity.StudyPlan;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 스터디 계획서의 CRUD를 담당하는 레포지토리 클래스
 *
 * @author ohksj(김승진)
 */
@Repository
public interface StudyPlanRepository extends JpaRepository<StudyPlan, Long> {
  @EntityGraph(attributePaths = {"studyGroup"})
  @Query(value = "select sp from StudyPlan sp where sp.studyGroup.id = :studyGroupId")
  Optional<StudyPlan> findByStudyGroup(Long studyGroupId);
}

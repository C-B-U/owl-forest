package com.cbu.backend.studyplan.repository;

import com.cbu.backend.studyplan.entity.StudyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanRepository extends JpaRepository<StudyPlan, Long> {}

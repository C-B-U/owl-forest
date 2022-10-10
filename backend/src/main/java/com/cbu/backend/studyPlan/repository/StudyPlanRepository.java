package com.cbu.backend.studyPlan.repository;

import com.cbu.backend.studyPlan.entity.StudyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanRepository extends JpaRepository<StudyPlan, Long> {

}

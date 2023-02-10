package com.cbu.backend.studyactivity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyActivityRepository extends JpaRepository<StudyActivity, Long> {
    List<StudyActivity> findAllByStudyGroupId(Long studyGroupId);
}

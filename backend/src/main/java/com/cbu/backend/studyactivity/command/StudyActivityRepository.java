package com.cbu.backend.studyactivity.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyActivityRepository extends JpaRepository<StudyActivity, Long> {}

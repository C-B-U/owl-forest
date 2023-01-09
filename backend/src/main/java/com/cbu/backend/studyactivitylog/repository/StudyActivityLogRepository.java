package com.cbu.backend.studyactivitylog.repository;

import com.cbu.backend.studyactivitylog.entity.StudyActivityLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyActivityLogRepository extends JpaRepository<StudyActivityLog, Long> {}

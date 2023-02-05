package com.cbu.backend.studyactivity.command.infra;

import com.cbu.backend.studyactivity.command.domain.StudyActivity;
import com.cbu.backend.studyactivity.command.domain.StudyActivityNo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyActivityRepository extends JpaRepository<StudyActivity, StudyActivityNo> {}

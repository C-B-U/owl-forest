package com.cbu.backend.studyactivitylog.command.infra;

import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLog;
import com.cbu.backend.studyactivitylog.command.domain.StudyActivityLogNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyActivityLogRepository extends JpaRepository<StudyActivityLog, StudyActivityLogNo> {}

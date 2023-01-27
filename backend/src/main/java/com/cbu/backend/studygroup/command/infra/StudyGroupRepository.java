package com.cbu.backend.studygroup.command.infra;

import com.cbu.backend.studygroup.command.domain.StudyGroup;
import com.cbu.backend.studygroup.command.domain.StudyGroupNo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends JpaRepository<StudyGroup, StudyGroupNo> {}

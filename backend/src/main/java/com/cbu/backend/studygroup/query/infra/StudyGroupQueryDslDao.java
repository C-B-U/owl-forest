package com.cbu.backend.studygroup.query.infra;

import com.cbu.backend.studygroup.command.domain.StudyGroup;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudyGroupQueryDslDao {
    List<StudyGroup> findAllStudyGroup(Pageable pageable);
}

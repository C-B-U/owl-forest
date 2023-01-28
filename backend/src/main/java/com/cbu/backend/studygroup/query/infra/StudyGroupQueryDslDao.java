package com.cbu.backend.studygroup.query.infra;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudyGroupQueryDslDao {
    List<StudyGroupResponse> findAllStudyGroup(Pageable pageable);

    StudyGroupResponse findResponseById(StudyGroupNo id);
}

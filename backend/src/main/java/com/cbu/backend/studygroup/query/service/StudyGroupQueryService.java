package com.cbu.backend.studygroup.query.service;

import com.cbu.backend.studygroup.command.domain.StudyGroupNo;
import com.cbu.backend.studygroup.query.dto.StudyGroupResponse;
import com.cbu.backend.studygroup.query.infra.StudyGroupDao;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyGroupQueryService {

    private final StudyGroupDao studyGroupDao;

    public StudyGroupResponse getStudyGroup(StudyGroupNo id) {
        return new StudyGroupResponse(studyGroupDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public List<StudyGroupResponse> getAllStudyGroup(Pageable pageable) {
        return studyGroupDao.findAllStudyGroup(pageable).stream()
                .map(StudyGroupResponse::new)
                .toList();
    }
}
